package com.example.testclient.codec;

import com.google.protobuf.MessageLite;
import com.example.testclient.protobuf.AckMessage;
import com.example.testclient.protobuf.ChatMessage;
import io.netty.buffer.ByteBuf;
import com.example.testclient.protobuf.GreetMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public class MessageEncoder extends MessageToByteEncoder<MessageLite> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLite msg, ByteBuf byteBuf) throws Exception {
        byte[] body = msg.toByteArray();
        byte[] header = new byte[4];
        short length = (short) body.length;
        byte messageType = 0x0f;

        if (msg instanceof ChatMessage) {
            messageType = 0x00;
        } else if (msg instanceof AckMessage) {
            messageType = 0x01;
        } else if (msg instanceof GreetMessage) {
            messageType = 0x02;
        }

        header[0] = (byte) (length & 0xff);
        header[1] = (byte) ((length >> 8) & 0xff);
        header[2] = 0; // 保留字段
        header[3] = messageType;

        byteBuf.writeBytes(header);
        byteBuf.writeBytes(body);
    }
}
