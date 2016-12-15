package javamultithread.ReadWriteLock;

import java.util.Random;

/**
 * 写线程
 * Created by stefan on 2016/2/19.
 */
public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private String filler;
    private int index = 0;

    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try{
            while(true) {
                char c = nextchar();
                data.write(c);
                System.out.println(Thread.currentThread().getName() + " write " + c);
                Thread.sleep(random.nextInt(3000));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextchar() {
        char c = filler.charAt(index);
        index++;
        if(index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
