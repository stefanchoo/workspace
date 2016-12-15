package com.africa.guava.study;

import com.google.common.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaProxy {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInvocationHandler();

        // Guava Dynamic Proxy implement
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething();

        //jdk Dynamic proxy implement
        IFoo jdkFoo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[]{IFoo.class},
                invocationHandler);
        jdkFoo.doSomething();
    }

    public static class MyInvocationHandler implements InvocationHandler{
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("proxy println something");
            return null;
        }
    }

    interface IFoo {
        void doSomething();
    }
}
