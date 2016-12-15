package com.aio.example.TimeServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by stefan on 2016/1/7.
 */
public class AsyncTimeServerHandler implements Runnable {
    private int port;

    CountDownLatch latch;                               // 线程辅助类，功能是让线程等待直至线程上所有的操作都完成
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try{
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept() {
        // 连接： attachment 为本身 + 处理器
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}

