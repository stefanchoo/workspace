package javamultithread.TwoPhaseThread;

import java.io.FileWriter;
import java.io.IOException;

/**
 * CountUpThread
 * 计数线程，每隔 1s 增加 1
 * Created by stefan on 2016/2/23.
 */
public class CountUpThread extends Thread {

    private long counter = 0;                                     // 计数器的值
    private volatile boolean shutdownRequested = false;           // 终止请求为true

    // 关闭请求
    public void shutdownRequest() {
        this.shutdownRequested = true;
        interrupt();                             // this is important, cause the thread is probably sleeping.
    }

    // 判断终止请求是否发出去
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public final void run() {
        try {
            while (!shutdownRequested) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }

    }

    // 工作
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter=" + counter);
        sleep(500);
    }

    // 终止处理
    private void doShutdown() {
        System.out.println("doShutdown begin");
        System.out.println("doShutdown: counter=" + counter);

        try{
            FileWriter writer = new FileWriter("count.txt");
            writer.write("counter=" + counter);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("doShutdown end");
    }
}
