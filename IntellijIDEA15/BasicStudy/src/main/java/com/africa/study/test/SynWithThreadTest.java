package com.africa.study.test;

/**
 * @author zhuhusheng
 * @date 2016/9/24
 */
public class SynWithThreadTest {
    public static void main(String[] args) {
        test();
//        test2();
    }

    private synchronized static void test() {
        System.out.println("开始：" + System.currentTimeMillis());
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            for (int i = 0; i < 10; i++) {
//                System.out.println("--->" + i);
//            }
//        }).start();
        new MyThread("myThread").start();
        new MyThread("myThread2").start();
        System.out.println("结束：" + System.currentTimeMillis());
    }

    private static void test2() {
        new MyThread("myThread2").run();
    }
}
