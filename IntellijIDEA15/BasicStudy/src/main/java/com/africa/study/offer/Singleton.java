package com.africa.study.offer;

import java.io.Serializable;

/**
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class Singleton implements Serializable {

    private static class SingletonHolder {
       public static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
