package javamultithread.Deadlock;

/**
 * Created by stefan on 2016/1/15.
 * 吃过程的 线程
 */
public class EaterThread extends Thread {
    private String name;
    private final Tool leftTool;
    private final Tool rightTool;

    public EaterThread(String name, Tool leftTool, Tool rightTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (leftTool) {
            System.out.println(name + " takes up " + leftTool + " (left).");
            synchronized (rightTool) {
                System.out.println(name + " takes up " + rightTool + " (right).");
                System.out.println(name + " is eating now, yam yam !");
                System.out.println(name + " puts down " + rightTool + " (right).");
            }
            System.out.println(name + " puts down " + leftTool + " (left).");
        }
    }
}
