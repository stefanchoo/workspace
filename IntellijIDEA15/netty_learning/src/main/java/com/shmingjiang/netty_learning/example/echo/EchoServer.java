package com.shmingjiang.netty_learning.example.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by stefan on 2016/1/4.
 */
public class EchoServer {
    private int port;

    EchoServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        // NioEventLoopGroup 是用来处理I/O操作的多线程事件循环器
        // 一个服务端应用通常有两个应用，一个bossGroup是用来接收进来的连接，workGroup是用来处理已经被接收的连接
        // 一旦boss接收到连接，就会把连接信息注册到worker上，可以处理有多少个线程被使用，如何映射到已经创建的channel上
        EventLoopGroup bossGroup = new NioEventLoopGroup();                   // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // ServerBootStrap 是一个启动NIO服务的辅助启动类
            ServerBootstrap b = new ServerBootstrap();                        // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)                    // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() {   // (4)
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)                     // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);            // (6)

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();                             // (7)

            // 等待服务器，socket关闭
            // 在这个例子中，这不会发生，但你可以优雅的关闭你的服务器
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new EchoServer(port).run();
    }
}
