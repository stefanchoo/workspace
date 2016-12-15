package com.shmingjiang.netty_learning.tcpsplicing.MessagePack;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by stefan on 2016/1/8.
 */
public class EchoClient {

    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("msgpack decoder", new MsgpackDecoder())
                                    .addLast("msgpack encoder", new MsgpackEncoder())
                                    .addLast(new EchoClientHandler(10));
                        }
                    });

            ChannelFuture f = b.connect(host, port).sync();

            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 8880;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        new EchoClient().connect("127.0.0.1", port);
    }
}
