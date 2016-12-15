package javamultithread.ThreadPerMessage;

/**
 * Thread-Per-Message Pattern
 * 一个消息对应一个线程
 * 提升响应性，降低延迟时间
 * Created by stefan on 2016/2/22.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main Begin");

        Host host = new Host();
        host.request(10, 'A');    // 1. invocation
        host.request(20, 'B');
        host.request(30, 'C');

        System.out.println("Main End");

    }
}
