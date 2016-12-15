package javamultithread.GuardSuspensionPattern;

import java.util.Random;

/**
 * TODO
 * Created by stefan on 2016/1/19.
 */
public class ServerThread extends Thread {

    private final Random random;
    private final RequestQueue queue;

    public ServerThread(RequestQueue queue, String name, long seed){
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles: " + request);
            try {
                Thread.sleep(random.nextInt(1000));   // 睡眠一定时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
