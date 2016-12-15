package com.africa.study.stampedLock;

/**
 * @author zhuhusheng
 * @date 2016/10/7
 */

/**
 * StampedLock
 * StampedLock控制锁有三种模式（写，读，乐观读），一个StampedLock状态是由版本和模式两个部分组成，
 * 锁获取方法返回一个数字作为票据stamp，它用相应的锁状态表示并控制访问，数字0表示没有写锁被授权访问。
 * 在读锁上分为悲观锁和乐观锁。
 *
 * 所谓的乐观读模式，也就是若读的操作很多，写的操作很少的情况下，你可以乐观地认为，写入与读取同时发生几率很少，
 * 因此不悲观地使用完全的读取锁定，程序可以查看读取资料之后，是否遭到写入执行的变更，
 * 再采取后续的措施（重新读取变更信息，或者抛出异常），这一个小小改进，可大幅度提高程序的吞吐量！
 */
public class StampedLockTest {
    public static void main(String[] args) {
        /*
        // #1. simple test
        BankAccountWithStampedLock bawsl = new BankAccountWithStampedLock();
        Thread aThread =  new Thread(() -> bawsl.deposit(100.109));
        Thread bThread = new Thread(() -> System.out.println(bawsl.getBalance()));

        aThread.start();
        bThread.start();
        */

        // #2. optimistic / pessimistic lock
        MyPoint point = new MyPoint(1.0, 2.1);
        new Thread(() -> point.moveIfAt(1.0, 2.1, 4.0, 4.0)).start();

        new Thread(() -> point.moveTo(3.0, 3.0)).start();
        new Thread(() -> point.moveIfAt(3.0, 3.0, 4.0, 4.0)).start();
        new Thread(() -> System.out.println(point.distanceFromOrigin())).start();
    }
}
