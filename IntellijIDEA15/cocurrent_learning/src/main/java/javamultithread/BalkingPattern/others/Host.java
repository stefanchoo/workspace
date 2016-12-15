package javamultithread.BalkingPattern.others;

import java.util.concurrent.TimeoutException;

/**
 * guarded timeout
 * Created by stefan on 2016/2/18.
 */
public class Host {
    private final long timeout;     // 等待时间
    private boolean ready = false;  // 可执行状态时，为true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecuable(boolean on) {
        ready = on;
        notifyAll();         // 通知所有操作它的线程
    }

    public synchronized void execute() throws Exception {
        long start = System.currentTimeMillis();
        while(!ready) {
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);
            if(rest <= 0) {
                System.out.println("TimeoutException happens...");
                throw new TimeoutException("耗时：" + (now - start) + ", timeout=" + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // 在线程花大量时间处理繁重工作时，可能来不及检查线程状态,
    // 这里增加 isInterrupted 来检查状态，
    // 使执行execute()可以中途退出
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            // 判断线程的状态
            if(Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        System.out.println("==> doHeavyJob Begins <==");
        long start = System.currentTimeMillis();
        while(10000 + start > System.currentTimeMillis()) {
           // doHeavyJob
        }
        System.out.println("==> doHeavyJob Ends <==");
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
