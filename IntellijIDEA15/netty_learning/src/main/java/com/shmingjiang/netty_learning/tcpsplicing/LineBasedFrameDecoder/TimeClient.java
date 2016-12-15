package com.shmingjiang.netty_learning.tcpsplicing.LineBasedFrameDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by stefan on 2016/1/4.
 * 事件服务器对应的客户端
 */
public class TimeClient {
    public static void main(String[] args) throws InterruptedException {

        String host = "127.0.0.1";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();                                // (1)
            b.group(workerGroup)                                          // (2)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)             // (3)
                    .handler(new ChannelInitializer<SocketChannel>() {    // (4)
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new EchoClientHandler());
                            ch.pipeline().
                                    addLast(new LineBasedFrameDecoder(1024)).
                                    addLast(new StringDecoder()).
                                    addLast(new TimeClientHandler());


                        }
                    });

            // 启动客户端
            // 发起异步连接，调用同步方法，等待连接成功
            ChannelFuture f = b.connect(host, port).sync();

            // 等到连接关闭
            f.channel().closeFuture().sync();
        } finally {

            workerGroup.shutdownGracefully();

        }
    }
}
