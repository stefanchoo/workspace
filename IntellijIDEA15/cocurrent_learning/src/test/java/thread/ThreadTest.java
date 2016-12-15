package thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by stefan on 2016/1/11.
 */
public class ThreadTest {

//    private static boolean stop;   // test 不加volatile, 效果跟加volatile结果一致

    private volatile boolean stop;

    @Test
    public void testVolatile() throws InterruptedException {
        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        workThread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }

}
