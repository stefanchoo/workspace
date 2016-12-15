package com.shmingjiang.netty_learning.tcpsplicing.LineBasedFrameDecoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by stefan on 2016/1/4.
 */
public class TimeServer {
    private int port;

    TimeServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        // NioEventLoopGroup 是用来处理I/O操作的线程组，包含一组NIO线程，实际上就是Reactor线程组
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
//                            ch.pipeline().addLast(new TimeServerHandler());    // !!!  出现粘包问题 !!!
                           // 解决之道！！！  LineBasedFrameDecoder 和 StringDecoder
                            ch.pipeline().
                                    addLast(new LineBasedFrameDecoder(1024)).    // 判断数据中是否有  \n 或者 \r\n,则结束，组成一行,最大长度为1024
                                    addLast(new StringDecoder()).                // 将接收得到字符串转化为字符串
                                    addLast(new TimeServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)                     // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);            // (6)

            // 绑定端口，开始接收进来的连接，同步阻塞方法等待绑定动作完成
            ChannelFuture f = b.bind(port).sync();                             // (7)

            // 等待服务器，socket关闭
            // 在这个例子中，这不会发生，但你可以优雅的关闭你的服务器
            // 调用阻塞的关闭方法，等待服务端链路关闭之后main函数才能退出
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
        new TimeServer(port).run();
    }
}
