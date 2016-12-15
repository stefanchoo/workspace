package com.shmingjiang.netty_learning.example.Test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by stefan on 2016/1/5.
 */
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 遇到 \n 换行
//        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(20, Delimiters.nulDelimiter()));
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("handler", new SimpleChatServerHandler());

        System.out.println("SimpleChatClient:" + ch.remoteAddress() + "连接上");
    }
}
