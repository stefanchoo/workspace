package javamultithread.ReadWriteLock;

/**
 * TODO
 * Created by stefan on 2016/2/19.
 */
public class ReaderThread extends Thread {
    private final Data data;
    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
