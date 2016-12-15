package com.africa.study.test;

/**
 * @author zhuhusheng
 * @date 2016/9/24
 */
public class MyThread extends Thread {
    public final String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("--->" + i);
        }
    }
}
