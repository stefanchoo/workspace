package javamultithread.ProducerConsumer;

/**
 * 就是通道 Channel
 * Created by stefan on 2016/2/18.
 */
public class Table {
    private final String[] buffer; // 放置蛋糕的缓冲区
    private int tail;   // 下一个放置蛋糕的地方
    private int head;   // 下一个拿取蛋糕的地方
    private int count;  // 表示现在桌子上蛋糕的数量

    public Table(int maxCakeNum) {
        this.buffer = new String[maxCakeNum];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;  // 这里考虑到可能会超过 buffer 的大小，所以不能++, 跟分页的概念一样
        count++;
//        notifyAll();
        notify();                 // 只唤醒一个线程
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
//        notifyAll();
        notify();             // 只唤醒一个线程
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    public synchronized void clear() {
        this.tail = 0;
        this.head = 0;
        this.count = 0;
        notifyAll();
    }
}
