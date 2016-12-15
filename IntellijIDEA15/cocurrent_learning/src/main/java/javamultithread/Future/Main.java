package javamultithread.Future;

/**
 * 测试未来模式
 * 请求发生后，立即返回一个持有 等待运算结果 的对象
 * 当运算结束后，可以再行获取
 * Created by stefan on 2016/2/22.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Main Begin");

        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        System.out.println("Main other jobs Begin");
        try{
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main other jobs End");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());

        System.out.println("Main END");
    }
}
