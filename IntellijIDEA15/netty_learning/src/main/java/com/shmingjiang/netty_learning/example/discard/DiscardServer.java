package com.shmingjiang.netty_learning.example.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by stefan on 2016/1/4.
 * 丢弃服务器
 * windows测试方法：
 * 使用Telnet命令，如没有安装，打开 控制面板 -> 程序 -> 启动或关闭Windows命令 -> 打开Telnet客户端
 * 1. 启动Java DiscardServer 服务器
 * 2. 在控制台输入 Telnet localhost 8080, 会弹出 Telnet localhost 窗口
 * 3. 在Telnet localhost 窗口输入字符 （一开始会看不到，建议使用 ctrl+] 退出，使用 send 命令来进行发送）
 * 4. 在控制台便可以看见发送的字符啦
 */
public class DiscardServer {
    private int port;

    DiscardServer(int port) {
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
                            // ！！！ ChannelPipeLine 是一个职责链，只是用来将多个handler连接在一块处理网络事件
                            ChannelPipeline pipeline = ch.pipeline();
                            System.out.println(pipeline.getClass().getName());
                            pipeline.addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)                     // (5) : 指定了最大的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true);            // (6)

            // 绑定端口，开始接收进来的连接， 当有新连接进来时才会创建childHandler中绑定的handler
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
        new DiscardServer(port).run();
    }
}
