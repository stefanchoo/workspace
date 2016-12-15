package javamultithread.commonMethod;

import java.util.Random;

/**
 * 取钱线程
 * Created by stefan on 2016/2/19.
 */
public class DrawThread extends Thread {
    private final Money money;

    public DrawThread(String name, Money money) {
        super(name);
        this.money = money;
    }

    @Override
    public void run() {
        try{
            Random random = new Random();
            while(true) {
                sleep(random.nextInt(1000));
                money.take(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " is interrupted.");
        }
    }
}

