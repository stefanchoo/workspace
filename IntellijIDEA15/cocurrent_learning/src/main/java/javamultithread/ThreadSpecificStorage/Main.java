package javamultithread.ThreadSpecificStorage;

/**
 * Main
 * 测试 每个线程的保管箱
 * Created by stefan on 2016/2/23.
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice-Thread").start();
        new ClientThread("Bily-Thread").start();
        new ClientThread("Cris-Thread").start();
    }
}
