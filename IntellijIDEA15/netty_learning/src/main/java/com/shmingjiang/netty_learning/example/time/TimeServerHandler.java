package com.shmingjiang.netty_learning.example.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by stefan on 2016/1/4.
 */
public final class TimeServerHandler extends ChannelInboundHandlerAdapter {

    // 在连接被建立并且准备进行通信时被调用。在此我们发送一个32位整数消息的构建工作

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {   // (1)
//        final ByteBuf time = ctx.alloc().buffer(4);                           // (2)
        final ByteBuf time = Unpooled.buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        // writeAndFlush() 方法会返回一个ChannelFuture对象，这个对象是还没有发生I/O操作的，这也
        // 意味着人任何一个请求操作都不会马上被执行，因为在netty中所有操作都是异步的
        final ChannelFuture f = ctx.writeAndFlush(time);                      // (3)
        try{
            f.addListener((ChannelFuture future) -> {
                assert f == future;
                ctx.close();
            });// (4)
        } catch (Exception e) {}

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
