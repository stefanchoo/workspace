package com.shmingjiang.netty_learning.tcpsplicing.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Created by stefan on 2016/1/8.
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        System.out.println("MsgpackEncoder -> encode()");
        MessagePack msgPack = new MessagePack();

        // 序列化
        byte[] raw = msgPack.write(msg);
        out.writeBytes(raw);
    }
}
