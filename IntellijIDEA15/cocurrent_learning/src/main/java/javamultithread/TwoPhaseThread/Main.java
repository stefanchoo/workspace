package javamultithread.TwoPhaseThread;

/**
 * Main
 * 测试 开始 -> 线程运行 -> 线程终止处理 -> 结束
 * Created by stefan on 2016/2/23.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main Begin");
        try {
            // 启动线程
            CountUpThread thread = new CountUpThread();
            thread.start();

            // 休息一段时间
            Thread.sleep(10000);

            // 对线程送出终止请求
            System.out.println("Main shutdownRequest");
            thread.shutdownRequest();

            System.out.println("Main join");

            // 等待线程结束
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main End");
    }
}
