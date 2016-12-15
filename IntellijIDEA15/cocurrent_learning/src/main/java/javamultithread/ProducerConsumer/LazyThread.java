package javamultithread.ProducerConsumer;

/**
 * 什么都不做的空线程
 *
 * 当 在table中调用 notify() 时，可能会唤醒这个线程
 * 1. 当蛋糕摆满了，而唤醒的是空线程时，程序就会卡住
 * 2. 当蛋糕没有了，而唤醒的是空线程时，程序也会卡住
 *
 * Created by stefan on 2016/2/19.
 */
public class LazyThread extends Thread {
    private final Table table;

    public LazyThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            try{
                synchronized (table) {
                    table.wait();
                }
                System.out.println(this.getName() + " is notified !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
