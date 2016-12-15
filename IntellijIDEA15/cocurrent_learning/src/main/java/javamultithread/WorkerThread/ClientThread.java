package javamultithread.WorkerThread;

import java.util.Random;

/**
 * 不断地创建request，传递给工人线程处理的 客户端线程
 * Created by stefan on 2016/2/22.
 */
public class ClientThread extends Thread {
    private final Channel channel;
    private static final Random random = new Random();
    private volatile boolean terminated = false;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; !terminated; i++) {
                Request request = new Request(getName(), i);   // invocation
                channel.putRequest(request);
                sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            terminated = true;
        }finally {
            System.out.println(Thread.currentThread().getName() + " is terminated.");
        }
    }

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}
