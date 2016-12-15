package javamultithread.ThreadPerMessage;

/**
 * 处理请求的主类
 * Created by stefan on 2016/2/22.
 */
public class Host {
    private final Helper helper = new Helper();
    public void request(final int count, final char c) {
        System.out.println("==> request(" + count + ", " + c + ") BEGIN");
        new Thread(()->{
            helper.handle(count, c);    // 如果不开线程就是同步操作！  // Execution
        }).start();   // 注意这里要是调用 run()， 新的线程不会启动，仍然由主线程负责处理，所以处理结果仍然与单线程一致
        System.out.println("==> request(" + count + ", " + c + ") END");
    }
}
