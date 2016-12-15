package javamultithread.GuardSuspensionPattern;

/**
 * TODO
 * Created by stefan on 2016/1/19.
 *
 * This is an example of Guard Suspension Pattern .
 * ！！ 我不准备好，你不能过来拿 ！！
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ServerThread(requestQueue, "Server", 13976565L).start();
        new ClientThread(requestQueue, "Client", 34555896L).start();
    }
}
