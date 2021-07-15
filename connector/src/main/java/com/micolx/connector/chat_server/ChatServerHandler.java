package com.micolx.connector.chat_server;

import com.google.protobuf.MessageLite;
import com.micolx.connector.SpringContext;
import com.micolx.connector.message_queue.MessagingService;
import com.micolx.connector.protobuf.AckMessage;
import com.micolx.connector.protobuf.AckType;
import com.micolx.connector.protobuf.ChatMessage;
import com.micolx.connector.protobuf.GreetMessage;
import com.micolx.connector.utility.SessionManager;
import com.micolx.connector.zookeeper.ZKRegister;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import java.util.List;


public class ChatServerHandler extends SimpleChannelInboundHandler<MessageLite> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServerHandler.class);
    private static final String ackSuffix = ".offlineAck";
    private static final String msgSuffix = ".offlineMsg";
    private String userId;
    private final SessionManager sessionManager = SpringContext.getBean(SessionManager.class);
    private final JedisPool jedisPool = SpringContext.getBean(JedisPool.class);
    private final MessagingService messagingService = SpringContext.getBean(MessagingService.class);
    private final ZKRegister zkRegister = SpringContext.getBean(ZKRegister.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageLite messageLite) {
        /*
        1. 回复ack
        2. 查找收件人是否在本server，是-直接转发，否-发给transfer
         */

        if (messageLite instanceof ChatMessage) {
            LOGGER.info("received a ChatMessage");
            ChatMessage chatMessage = (ChatMessage) messageLite;

            // reply "sent" ack
            AckMessage.Builder builder = AckMessage.newBuilder();
            builder.setMsgID(chatMessage.getMsgID());
            builder.setType(AckType.SENT);
            channelHandlerContext.writeAndFlush(builder.build());

            String destId = chatMessage.getRecipientID();

            // lookup recipient locally
            if (sessionManager.userExist(destId)) {
                sessionManager.getChannelFromID(destId).writeAndFlush(chatMessage);
            } else {
                try (Jedis jedis = jedisPool.getResource()) {
                    // check if recipient online
                    String serverId = jedis.get(destId);
                    if (serverId != null) {
                        // recipient is online, send to mq
                        LOGGER.info("recipient is online, send chat message to mq");
                        messagingService.forwardMessage(serverId, chatMessage);
                    } else {
                        // recipient is offline, put in redis list
                        LOGGER.info("recipient is offline, put chat message in redis list");
                        jedis.rpush(destId + msgSuffix, new String(chatMessage.toByteArray()));
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        } else if (messageLite instanceof AckMessage) {
            LOGGER.info("received an AckMessage");
            AckMessage ackMessage = (AckMessage) messageLite;

            // lookup recipient locally
            String destId = ackMessage.getRecipientID();
            if (!destId.equals(userId)) {
                if (sessionManager.userExist(destId)) {
                    sessionManager.getChannelFromID(destId).writeAndFlush(ackMessage);
                } else {
                    try (Jedis jedis = jedisPool.getResource()) {
                        // check if recipient online
                        String serverId = jedis.get(destId);
                        if (serverId != null) {
                            // recipient is online, send ack to mq
                            messagingService.forwardAck(serverId, ackMessage);
                        } else {
                            // recipient is offline, put ack in redis list
                            jedis.rpush(destId + ackSuffix, new String(ackMessage.toByteArray()));
                        }
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }

            // TO-DO: if ack="received", push to history database
        } else if (messageLite instanceof GreetMessage) {
            LOGGER.info("received an GreetMessage");
            GreetMessage greetMessage = (GreetMessage) messageLite;
            userId = greetMessage.getUserId();
            sessionManager.put(userId, channelHandlerContext);

            try (Jedis jedis = jedisPool.getResource()) {
                // put route info in redis
                jedis.set(userId, ServerID.getID());

                // pull offline ack from redis
                List<String> offlineAck = jedis.lrange(userId + ackSuffix, 0, -1);
                if (offlineAck != null && !offlineAck.isEmpty()) {
                    LOGGER.info("found offline ack Message of user " + userId);
                    for (String ack : offlineAck) {
                        AckMessage ackMessage = AckMessage.parseFrom(ack.getBytes());
                        channelHandlerContext.writeAndFlush(ackMessage);
                    }

                    // clear offline ack on redis
                    jedis.del(userId + ackSuffix);
                }

                // pull offline message from redis
                List<String> offlineMessages = jedis.lrange(userId + msgSuffix, 0, -1);
                if (offlineMessages != null && !offlineMessages.isEmpty()) {
                    LOGGER.info("found offline chat Message of user "+userId);
                    for (String msg : offlineMessages) {
                        ChatMessage chatMessage = ChatMessage.parseFrom(msg.getBytes());
                        channelHandlerContext.writeAndFlush(chatMessage);
                    }

                    // clear offline message on redis
                    jedis.del(userId + msgSuffix);
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        } else {
            LOGGER.error("Message type error, not a chatMessage");
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        LOGGER.info("Channel active");
        zkRegister.change(1);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        LOGGER.info("channel inactive");
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionManager.remove(userId);
        zkRegister.change(-1);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
