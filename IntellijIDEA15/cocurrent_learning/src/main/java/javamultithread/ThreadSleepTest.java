package javamultithread;

/**
 * Created by stefan on 2016/1/14.
 */
public class ThreadSleepTest {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        try {
            t.sleep(10000);    // 这里等价于 Thread.sleep(10000); 线程t并不会休息， 主线程会休息
                               // 要想t休息，需要在run()方法中执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你停止了吗？");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try{
                sleep(800);    // 这里会让线程休息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Hello ");
        }
    }
}