package javamultithread.BalkingPattern;

/**
 * 测试 Balking Pattern 的主类
 * Created by stefan on 2016/2/18.
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
