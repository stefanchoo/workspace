package com.aio.example.TimeServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by stefan on 2016/1/7.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
        if (asynchronousSocketChannel != null) {
            this.asynchronousSocketChannel = asynchronousSocketChannel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("The time server receive order : " + req);
            String currentTime = req.equalsIgnoreCase("QUERY TIME ORDER") ?
                    new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
            doWrite(currentTime);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void doWrite (String currentTime) {
        /*
         *  1. 判断要写的数据
         *  2. 将要写的数据转化为byte[]数组
         *  3. 根据数组大小，申请writeBuffer
         *  4. 将数据写入writeBuffer
         *  5. 调换writeBuffer为读指针状态
         *  6. 调用asynchronousSocketChannel异步写函数
         *
         *  第一个参数 src： 要写的buffer
         *  第二个参数：attachment: IO操作的附着对象
         *  第三个参数：CompletionHandler: 异步回调接口,处理回调结果的handler, 有两个函数，成功或者失败
         *
         */

        if(currentTime != null && currentTime.trim().length() > 0) {
            byte[] bytes = currentTime.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if(writeBuffer == attachment) System.out.println("我们是相等的");
                    // 如果没有发送完，继续发送
                    if (attachment.hasRemaining()) {
                        // 没有发送完，继续交给你处理
                        asynchronousSocketChannel.write(attachment, attachment, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        asynchronousSocketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            asynchronousSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
