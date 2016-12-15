package com.africa.study.reflect;

/**
 * @author zhuhusheng
 * @date 2016/9/5
 */
public class Cat {
    public static int count;
    public int age;
    private String name;

    static {
        count = 1;
    }

    public Cat(){
        this.age = count++;
        System.out.println("this is class Cat!");
    }

    public void run(){}

    private void ruff(){}
}
