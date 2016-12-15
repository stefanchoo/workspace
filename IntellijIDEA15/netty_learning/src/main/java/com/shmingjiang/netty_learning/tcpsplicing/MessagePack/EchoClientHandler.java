package com.shmingjiang.netty_learning.tcpsplicing.MessagePack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by stefan on 2016/1/8.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private final int sendNumber;

    public EchoClientHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        User[] users = getUsers();
        for (User u : users) {
            // System.out.println(u.toString());
            ctx.write(u);
        }
        ctx.flush();
    }

    private User[] getUsers() {
        User[] users = new User[sendNumber];
        User u = null;
        for (int i = 0; i < sendNumber; i++) {
            u = new User();
            u.setUserId(i);
            u.setUserName("stefan ---> " + i);
            users[i] = u;
        }
        return users;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msgpack message : " + msg.toString());
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
