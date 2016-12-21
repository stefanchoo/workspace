package com.africa.study.annotation;

/**
 * @author zhuhusheng
 * @date 2016/12/21
 */
public class ReflectTest {

    @Reflect
    public static void sayHello(final String name) {
        System.out.println("==>> Hi, " + name + " [sayHello]");
    }

    @Reflect(name = "AngelaBaby")
    public static void sayHelloToSomeone(final String name){
        System.out.println("==>> Hi, " + name + " [sayHelloToSomeone]");
    }

    public static void main(String[] args) throws Exception {
        final ReflectProcessor processor = new ReflectProcessor();
        processor.parseMethod(ReflectTest.class);
    }
}
