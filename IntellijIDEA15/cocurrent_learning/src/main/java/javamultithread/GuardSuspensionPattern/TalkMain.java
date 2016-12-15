package javamultithread.GuardSuspensionPattern;

/**
 * TODO
 * Created by stefan on 2016/1/19.
 * 使用request 模拟聊天的主类
 */
public class TalkMain {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();

        // 如果一开始不放进去的话，就会发生死锁，
        // requestQueue1在等requestQueue2 putRequest()
        // requestQueue2在等requestQueue1 putRequest()
        requestQueue1.putRequest(new Request("Hello"));

        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
        new TalkThread(requestQueue2, requestQueue1, "Bob").start();
    }
}
