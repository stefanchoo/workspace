package javamultithread.GuardSuspensionPattern;

import java.util.LinkedList;

/**
 * 模拟请求的类
 * Created by stefan on 2016/1/19.
 */
public class RequestQueue {
    public final LinkedList<Request> queues = new LinkedList<>();

    public synchronized Request getRequest() {

        while(queues.size() < 1) {                        // guard condition
            // 1. 使用if,在本例中因为只有一个线程调用，所以问题不大，但是如果是有多个线程访问的时候，比如在notifyAll() 之后
            // 多个线程都被唤醒了，当首先获得锁的线程执行了removeFirst()方法之后，queues的size为0，其他线程不做判断的情况下
            // 又再次执行removeFirst(),就会出现安全问题。
//        if(queues.size() < 1){
            try{
                System.out.println(Thread.currentThread().getName() + " wait ...");
                // 注意这里千万不能用sleep(), 因为sleep()不会释放对实例的锁，其他线程无法进入执行方法，导致queue的size永远为0
                // 属于自己作死的情况，自个把自个 block 住了, 结果显示会一直处于卡在这里
//                Thread.sleep(100);
                wait();
                System.out.println(Thread.currentThread().getName() + " wake up...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return (Request)queues.removeFirst();
    }

    public synchronized void putRequest(Request request) {
        notifyAll();                                    // 放在这里也是不影响的，因为此时唤醒的线程还拿不到对象的锁
        queues.addLast(request);
//        notifyAll();                                  // 完成之后 guard condition 就不满足了
        System.out.println(Thread.currentThread().getName() + " notify all...");
    }
}
