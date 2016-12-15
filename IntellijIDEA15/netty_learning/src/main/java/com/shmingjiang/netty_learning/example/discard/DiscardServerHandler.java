package com.shmingjiang.netty_learning.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by stefan on 2016/1/4.
 * 处理服务端 channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {        // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {   // (2)
        // 默默丢掉收到的数据
//        ((ByteBuf) msg).release();           // (3)

        // 处理数据，让其显示
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
