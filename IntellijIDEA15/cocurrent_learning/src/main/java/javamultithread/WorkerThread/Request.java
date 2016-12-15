package javamultithread.WorkerThread;

import java.util.Random;

/**
 * 请求类
 * Created by stefan on 2016/2/22.
 */
public class Request {
    private final String name;     // 委托者
    private final int number;      // 编号
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try{
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
