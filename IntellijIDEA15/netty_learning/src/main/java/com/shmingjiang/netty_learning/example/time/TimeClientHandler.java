package com.shmingjiang.netty_learning.example.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by stefan on 2016/1/4.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

   /*
    * Solution1: 自行处理， 通过截取buf的长度来确定数据是否读取完毕
    *
   private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added ...");
        buf = ctx.alloc().buffer(4);                                // (1)
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release();
        buf = null;
        System.out.println("handler removed ...");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        buf.writeBytes(m);
        m.release();

        if (buf.readableBytes() >= 4) {
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
     // 如果不做任何处理会报IndexOutOfBoundsException,这是因为TCP/IP是基于流传输的，不管你发送多少数据包，接收方接收到的数据都会以队列形式
     // 放在同一个流中，具体是因为IP分片造成的
        ByteBuf m = (ByteBuf) msg;          // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

