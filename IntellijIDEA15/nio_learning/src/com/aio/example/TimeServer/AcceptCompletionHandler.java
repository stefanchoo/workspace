package com.aio.example.TimeServer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by stefan on 2016/1/7.
 *  读进来的是 AsyncTimeServerHandler， 要处理成 AsynchronousSocketChannel
 */
public class AcceptCompletionHandler implements CompletionHandler
        <AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {

        // 如果连接完成后会进入这里，我们需重新将AsyncTimeServerHandler置于可接收连接状态，从而形成一个循环
        attachment.asynchronousServerSocketChannel.accept(attachment, this);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 异步读函数， src : buffer , attachment : buffer, completionHandler ： readCompletionHandler
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();   // release all threads
    }
}

