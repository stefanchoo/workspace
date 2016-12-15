package javamultithread.SingleThreadExecution;

/**
 * Created by stefan on 2016/1/14.
 * SingleThreadExecuition Patttern
 * 程序实现 ：使三个人不断地穿梭一扇门，并记录穿过时的姓名和地址
 * 通过synchronized同步锁实现线程安全
 */
public class Main {
    public static void main(String[] args) {
        // 1. 新建一扇门
        Gate gate = new Gate();
        new GateThread(gate, "Alice", "Alago").start();
        new GateThread(gate, "Bob", "Boston").start();
        new GateThread(gate, "Crandy", "Chicago").start();
    }
}
