package javamultithread.WorkerThread;

/**
 * 测试一下 工人线程 模式
 * Created by stefan on 2016/2/22.
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();

        ClientThread alice = new ClientThread("Alice", channel);       // 委托方
        ClientThread bob = new ClientThread("Bob", channel);
        ClientThread crandy = new ClientThread("Crandy", channel);

        alice.start();
        bob.start();
        crandy.start();

        try{
           Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        alice.stopThread();
        bob.stopThread();
        crandy.stopThread();

        channel.stopWorkers();
    }
}
