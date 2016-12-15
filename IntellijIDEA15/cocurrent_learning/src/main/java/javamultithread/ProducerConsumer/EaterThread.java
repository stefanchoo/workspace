package javamultithread.ProducerConsumer;

import java.util.Random;

/**
 * TODO
 * Created by stefan on 2016/2/18.
 */
public class EaterThread extends Thread {
    private final Table table;
    private final Random random;

    public EaterThread(String name, Table table, long seed){
        super(name);
        this.table = table;
        random = new Random(seed);
    }

    @Override
    public void run() {
        try{
            while(true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
