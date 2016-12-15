package com.shmingjiang.netty_learning.example.POJO;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by stefan on 2016/1/4.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    // 在连接被建立并且准备进行通信时被调用。在此我们发送一个32位整数消息的构建工作

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {   // (1)

        final ChannelFuture f = ctx.writeAndFlush(new UnixTime());                      // (3)
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
