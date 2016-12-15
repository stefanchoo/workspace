package javamultithread.commonMethod;

/**
 * 测试一下 wait sleep join 与 interrupt
 *
 * wait notify & notifyAll 是指实例的行为
 * sleep join interrupt yield 是指线程的行为
 *
 * 1. 实例方法
 * 实例执行wait，持有其锁定的线程便会停止操作，进入等待区，释放对实例的锁定
 * 只有执行notify、notifyAll、interrupt 之后会被唤醒，需要重新获取实例的锁
 *
 * 2. 线程方法
 * 线程执行sleep，进入休息状态，此时仍然持有其操作实例的锁定
 * 线程执行join(mills)， 表示其他线程需要等待mills时间，让该线程结束，此时仍然持有其操作实例的锁定
 * 线程执行interrupt, 会将线程的状态改变为 中断状态， 紧接着在线程检查其自身状态时，会抛出interruptedException
 * 线程执行yield, 表示其已经执行完自己的方法，可以将时间让给其他线程使用，同时其仍然还可以获取CPU分配时间的权利
 *
 * 3. InterruptedException
 * sleep / wait / join 会检查自身状态是否处于中断状态
 * 线程调用 interrupt() 方法，由非中断状态 -> 中断状态
 * 线程调用 interrupted() 方法，由中断状态 -> 非中断状态
 *
 * Created by stefan on 2016/2/19.
 */
public class Main {
    public static void main(String[] args) {
        Money money = new Money(1000);
        Thread deposit = new DepositThread("Deposit-Thread", money);
        Thread draw = new DrawThread("Draw-Thread", money);
        deposit.start();
        draw.start();
    }
}
