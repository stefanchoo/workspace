package com.aio.example.TimeServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by stefan on 2016/1/7.
 */
public class AsyncTimeClientHandler implements Runnable, CompletionHandler<Void, AsyncTimeClientHandler> {

    private String host;
    private int port;

    private AsynchronousSocketChannel client;

    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        client.connect(new InetSocketAddress(host, port), this, this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req = "QUERY TIME ORDER" .getBytes();
        ByteBuffer writerBuffer = ByteBuffer.allocate(req.length);
        writerBuffer.put(req);
        writerBuffer.flip();

        attachment.client.write(writerBuffer, writerBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()) {
                    client.write(writerBuffer, writerBuffer, this);
                } else {
                    /*  0. 申请1k的buffer,将channel中的数据写入
                     *  1. buffer切换为读指针
                     *  2. 根据buffer大小申请bytes数组
                     *  3. 将buffer写入byte[]
                     *  4. 将bytes数组转化为“UTF-8”的字符串
                     *  5. 清空线程
                     */
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            String body;
                            try{
                                body = new String(bytes, "UTF-8");
                                System.out.println("Now is : " + body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                client.close();
                                latch.countDown();
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
                    client.close();
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
