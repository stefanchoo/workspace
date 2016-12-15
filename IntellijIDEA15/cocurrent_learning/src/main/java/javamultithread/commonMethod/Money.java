package javamultithread.commonMethod;

/**
 * TODO
 * Created by stefan on 2016/2/19.
 */
public class Money {

    private double nowMoney;

    public Money(double account) {
        this.nowMoney = account;
    }

    public synchronized void take(double money) throws InterruptedException {
        //long start = System.currentTimeMillis();
        while(money > nowMoney) {
//            long now = System.currentTimeMillis();
//            if(now - start > 5000){
//                Thread.currentThread().interrupt();
//            }
//            System.err.println(Thread.currentThread().getName() + " wait " + (now - start));
//            wait(now - start);
            System.err.println(Thread.currentThread().getName() + " wait ");
            Thread.currentThread().join(5000);      // 最多等待 5s 让该线程结束，如果时间到未结束，则 break, 其他线程不运行？
            if(Thread.currentThread().isAlive()){
                Thread.currentThread().interrupt();
            }
//            wait(5000);                           // wait 是只操作的该实例
        }
        nowMoney -= money;
        System.out.println(Thread.currentThread().getName() + " take " + money + ", left " + nowMoney);
    }

    public synchronized void put(double money) {
        nowMoney += money;
        System.out.println(Thread.currentThread().getName() + " put " + money + ", left " + nowMoney);
        notifyAll();
    }
}
