package javamultithread.ProducerConsumer;

import java.util.Random;

/**
 * TODO
 * Created by stefan on 2016/2/18.
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;   // 这里所有的厨师共享蛋糕流水号

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try{
            while(true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake NO." + nextId() + "] by " + getName() + "";
                table.put(cake);
            }
        }catch (InterruptedException e) {
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
