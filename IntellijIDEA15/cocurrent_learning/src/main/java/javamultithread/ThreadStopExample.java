package javamultithread;

import java.util.concurrent.TimeUnit;

/**
 * Created by stefan on 2016/1/11.
 */
public class ThreadStopExample {
//        private static boolean stop;       // output : 第三次运行
    private volatile static boolean stop;    // output : 第四次运行  !! 后来又是三次啦

    public static void main(String[] args) throws InterruptedException {
        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
               long start =  System.currentTimeMillis();
                int i = 0;
                while (!stop) {
                    i++;
                    try {
                        System.out.println("第 " + i + " 次运行");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long stop = System.currentTimeMillis();
                System.out.println("用时：" + (stop - start));
            }
        });
        workThread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }
}
