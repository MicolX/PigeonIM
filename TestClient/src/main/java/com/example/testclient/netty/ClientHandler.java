package com.example.testclient.netty;

import com.example.testclient.protobuf.AckMessage;
import com.example.testclient.protobuf.AckType;
import com.example.testclient.protobuf.ChatMessage;
import com.example.testclient.protobuf.GreetMessage;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import java.time.LocalDateTime;

public class ClientHandler extends SimpleChannelInboundHandler<MessageLite> {
    private static final AttributeKey<String> ATTRIBUTE_KEY = AttributeKey.valueOf("USERID");

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageLite messageLite) throws Exception {
        if (messageLite instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) messageLite;
            String time = chatMessage.getTime();
            String msg = chatMessage.getContent();
            String sender = chatMessage.getSenderID();
            String userId = channelHandlerContext.channel().attr(ATTRIBUTE_KEY).get();
            System.out.println(time+" from "+sender+": "+msg);
            AckMessage.Builder builder = AckMessage.newBuilder();
            builder.setMsgID(chatMessage.getMsgID());
            builder.setRecipientID(userId);
            channelHandlerContext.writeAndFlush(builder.build());
        } else if (messageLite instanceof AckMessage) {
            AckMessage ackMessage = (AckMessage) messageLite;
            String recipient = ackMessage.getRecipientID();
            String msgId = ackMessage.getMsgID();
            if (ackMessage.getType() == AckType.READ) {
                System.out.println(recipient+" has read message "+msgId);
            } else if (ackMessage.getType() == AckType.SENT) {
                System.out.println("message "+msgId+" has been sent");
            } else if (ackMessage.getType() == AckType.RECEIVED) {
                System.out.println("message "+msgId+" has been received");
            } else {
                System.out.println("error ack type");
            }
        } else {
            System.out.println("error message type");
        }
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String userId = ctx.channel().attr(ATTRIBUTE_KEY).get();
        GreetMessage.Builder builder = GreetMessage.newBuilder();
        builder.setTime(LocalDateTime.now().toString());
        builder.setUserId(userId);
        ctx.writeAndFlush(builder.build());
    }
}
