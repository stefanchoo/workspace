package javamultithread.commonMethod;

import java.util.Random;

/**
 * 存钱线程
 * Created by stefan on 2016/2/19.
 */
public class DepositThread extends Thread {
    private final Money money;

    public DepositThread(String name, Money money) {
        super(name);
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running ");
        try{
            Random random = new Random();
            while(true) {
                sleep(random.nextInt(2000));
                money.put(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " is interrupted.");
        }

    }
}
