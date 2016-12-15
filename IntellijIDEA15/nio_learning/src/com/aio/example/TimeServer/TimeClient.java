package com.aio.example.TimeServer;

/**
 * Created by stefan on 2016/1/7.
 */
public class TimeClient {

    public static void main (String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        AsyncTimeClientHandler timeClient = new AsyncTimeClientHandler("127.0.0.1", port);
        new Thread(timeClient, "AIO-AsyncTimeClientHandler-001").start();
    }
}
