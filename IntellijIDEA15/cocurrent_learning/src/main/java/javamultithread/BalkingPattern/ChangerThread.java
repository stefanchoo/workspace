package javamultithread.BalkingPattern;

import java.io.IOException;
import java.util.Random;

/**
 * 修改的线程
 * Created by stefan on 2016/2/18.
 */
public class ChangerThread extends Thread {
    private Data data;
    private Random random = new Random();   // 构造随机改变content的情况

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("NO." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
