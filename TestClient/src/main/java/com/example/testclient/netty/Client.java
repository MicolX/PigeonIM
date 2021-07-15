package com.example.testclient.netty;

import com.example.testclient.codec.MessageDecoder;
import com.example.testclient.codec.MessageEncoder;
import com.example.testclient.protobuf.ChatMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;


public class Client {

    private static final AttributeKey<String> ATTRIBUTE_KEY = AttributeKey.valueOf("USERID");
    private Channel channel;
    private int msgId;
    private final String userId;

    public Client(String userId) {
        this.userId = userId;
        msgId = 0;
    }

    public void connect(String ip, int port) {
        Bootstrap b = new Bootstrap();
        ChannelFuture f = null;
        try {
            f = b.group(new NioEventLoopGroup())
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("decoder", new MessageDecoder())
                                    .addLast("encoder", new MessageEncoder())
                                    .addLast(new ClientHandler());
                        }
                    }).register().await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (f != null && f.isSuccess()) {
            channel = f.channel();
            channel.attr(ATTRIBUTE_KEY).set(userId);
            channel.connect(new InetSocketAddress(ip, port)).addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("connected to server successfully");
                }
            });
        }

    }

    public void send(String msg, String to) {
        ChatMessage.Builder builder = ChatMessage.newBuilder();
        builder.setContent(msg);
        builder.setRecipientID(to);
        builder.setSenderID(userId);
        builder.setMsgID(String.valueOf(msgId));
        builder.setSequenceID(msgId++);
        builder.setTime(LocalDateTime.now().toString());
        channel.writeAndFlush(builder.build());
    }

    public void disconnect() {
        channel.close();
    }
}
