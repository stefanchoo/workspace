package javamultithread.BalkingPattern.others;

/**
 * 测试 延时
 * Created by stefan on 2016/2/18.
 */
public class Main {
    public static void main(String[] args) {
        /*
        Host host = new Host(10000);
        try{
            System.out.println("Execute Begins:");
            host.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        Thread executor = new Thread(
                ()->{
                    System.out.println("Execute Begins:");
                    try{
                        Host.execute(100);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Execute Ends:");
                }
        );

        // 启动
        executor.start();

        // 休息 15s
        try{
            Thread.sleep(15000);
        } catch (InterruptedException e) {}

        // 停止
        System.err.println("===> interrupt <===");
        executor.interrupt();
    }
}
