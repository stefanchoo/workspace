package com.shmingjiang.netty_learning.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;

/**
 * @author zhuhusheng
 * @date 2016/10/13
 */
public class SocketTest {
    public static void main(String[] args) throws Exception {
        int count = 0;
        String msg = "JDA|model=192TMFG|description=闪银|weight=56/46kg|\r";
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("192.168.1.10", 3003);
        socket.connect(socketAddress);
        while(true) {
            System.out.println(count++);
            new Thread(() -> {
                try{
                    socket.getOutputStream().write(msg.getBytes(Charset.forName("UTF-16LE")));
                    socket.getOutputStream().flush();
                    System.out.println(socket.getInputStream().read());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
            Thread.sleep(10000);
        }


    }
}
