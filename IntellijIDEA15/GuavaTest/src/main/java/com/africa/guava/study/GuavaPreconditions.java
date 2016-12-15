package com.africa.guava.study;

import com.google.common.base.Preconditions;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaPreconditions {
    public static void main(String[] args) {
        GuavaPreconditions gp = new GuavaPreconditions();
        gp.doSomething("", 18, "dsdsdsdsd");
    }

    public void doSomething(String name, int age, String desc) {
        Preconditions.checkNotNull(name, "name may not be null");
        Preconditions.checkArgument(age >= 18 && age < 99, "age must in range (18,99)");
        Preconditions.checkArgument(desc != null && desc.length() < 10, "desc too long, max length is ", 10);

        //do things
        System.out.println("测试通过！");
    }
}
