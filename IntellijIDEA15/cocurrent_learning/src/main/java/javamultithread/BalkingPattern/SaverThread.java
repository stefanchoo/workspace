package javamultithread.BalkingPattern;

import java.io.IOException;

/**
 * 自动保存的线程
 * Created by stefan on 2016/2/18.
 */
public class SaverThread extends Thread {
    private Data data;
    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true) {
                data.save();
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
