package com.example.testclient.codec;

import com.google.protobuf.MessageLite;
import com.example.testclient.protobuf.AckMessage;
import com.example.testclient.protobuf.ChatMessage;
import io.netty.buffer.ByteBuf;
import com.example.testclient.protobuf.GreetMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (byteBuf.readableBytes() > 4) {
            byteBuf.markReaderIndex();

            byte low = byteBuf.readByte();
            byte high = byteBuf.readByte();
            short s0 = (short) (low & 0xff);
            short s1 = (short) (high & 0xff);
            s1 <<= 8;
            short length = (short) (s0 | s1);

            byteBuf.readByte(); // 保留字段
            byte dataType = byteBuf.readByte();

            if (byteBuf.readableBytes() < length) {  // if incomplete package
                byteBuf.resetReaderIndex();
                return;
            }

            ByteBuf bodyByteBuf = byteBuf.readBytes(length);
            byte[] array;
            int offset;

            int readableLen = bodyByteBuf.readableBytes();
            if (bodyByteBuf.hasArray()) {
                array = bodyByteBuf.array();
                offset = bodyByteBuf.arrayOffset() + bodyByteBuf.readerIndex();
            } else {
                array = new byte[readableLen];
                bodyByteBuf.getBytes(bodyByteBuf.readerIndex(), array, 0, readableLen);
                offset = 0;
            }

            MessageLite result;
            if (dataType == 0x00) {
                result = ChatMessage.getDefaultInstance().getParserForType().parseFrom(array, offset, length);
            } else if (dataType == 0x01) {
                result = AckMessage.getDefaultInstance().getParserForType().parseFrom(array, offset, length);
            } else if (dataType == 0x02) {
                result = GreetMessage.getDefaultInstance().getParserForType().parseFrom(array, offset, length);
            } else {
                throw new IllegalStateException("unknown type message");
            }

            list.add(result);
        }
    }
}
