package com.shmingjiang.netty_learning.example.POJO;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created by stefan on 2016/1/4.
 */
public class TimeEncoder extends ChannelOutboundHandlerAdapter {
    //  ChannelPromise : 会返回编码后的数据写到通道上的成功与否
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime m = (UnixTime)msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt((int)m.value());
        ctx.write(encoded, promise);
    }
}
