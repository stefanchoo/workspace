package javamultithread.SingleThreadExecution;

/**
 * Created by stefan on 2016/1/14.
 *
 *  转化成线程安全的
 *  注意这里没有在check()方法上加synchronized
 *  原因是：pass()方法被线程锁定后，才会进入check()方法，而且check()为private，
 *  所以别的线程在被其中一个线程锁定的情况下无法访问，保证了安全性
 *
 */
public class Gate {
    private long counter;   // 通过门的次数
    private String name;    // 姓名
    private String address; // 地址

    public synchronized void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;

        // 加快错误出现时间
        try{
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        check();
    }

    @Override
    public synchronized String toString(){
        return "NO:"+counter +" "+ name + ":" + address;
    }

    private void check(){
        if(this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("********** BROKEN ********** " + toString());
        }
    }
}
