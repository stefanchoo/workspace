package com.shmingjiang.netty_learning.example.Test;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by stefan on 2016/1/5.
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
//        ctx.writeAndFlush("CMD01");
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "异常");

        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.err.println("消息:" + msg);
        switch (msg) {
            case "CMD01":
                ctx.writeAndFlush("CMD01");
                break;
            case "CMD02":
                ctx.writeAndFlush("CMD02");
                break;
            case "CMD03":
                ctx.writeAndFlush("CMD03");
                break;
            case "CMD04":
                ctx.writeAndFlush("CMD04");
                break;
            case "CMD07":
                ctx.writeAndFlush("CMD072234");
                break;
            case "CMD08":
                ctx.writeAndFlush("1");
                break;
        }
    }
}

