package com.shmingjiang.netty_learning.example.simplechat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by stefan on 2016/1/5.
 */
public class SimpleChatClient {
    public static void main(String[] args) throws Exception {
        new SimpleChatClient("localhost", 8080).run();
    }

    private final String host;
    private final int port;

    public SimpleChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap cb = new Bootstrap();
            cb.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
                    .handler(new SimpleChatClientInitializer());

            Channel channel = cb.connect(host, port).sync().channel();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                channel.writeAndFlush(in.readLine() + "\r\n");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
