package javamultithread.GuardSuspensionPattern;

/**
 * TODO
 * Created by stefan on 2016/1/19.
 */
public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name){
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Begins ");
        for (int i = 0; i < 20; i++) {

            // 获取对方请求
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            // 加一个 ！ 发给对方
            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }
    }
}
