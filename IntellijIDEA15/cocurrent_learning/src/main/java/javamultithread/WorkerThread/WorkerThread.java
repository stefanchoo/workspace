package javamultithread.WorkerThread;

/**
 * 工人线程只需要将request 拿出来 处理一下
 * Created by stefan on 2016/2/22.
 */
public class WorkerThread extends Thread {
    private final Channel channel;
    private volatile boolean terminated = false;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            while(!terminated) {
                try{
                    channel.takeRequest().execute();    // Execution
                } catch (InterruptedException e) {
                    terminated = true;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " is terminated.");
        }

    }

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}
