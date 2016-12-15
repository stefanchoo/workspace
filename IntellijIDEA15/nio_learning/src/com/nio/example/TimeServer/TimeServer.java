package com.nio.example.TimeServer;

import java.io.IOException;

/**
 * Created by stefan on 2016/1/6.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {

        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
