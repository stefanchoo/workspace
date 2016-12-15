package com.shmingjiang.netty_learning.example.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by stefan on 2016/1/4.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);                          // 将消息写入到缓存区
        ctx.flush();                             // 将缓存区的数据输出
        // ctx.writeAndFlush(msg);
    }
}
