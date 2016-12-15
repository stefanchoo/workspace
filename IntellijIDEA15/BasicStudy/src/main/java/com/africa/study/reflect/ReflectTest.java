package com.africa.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhuhusheng
 * @date 2016/9/5
 */
public class ReflectTest {
    public static void main(String[] args) {
        Class c = Cat.class;
        for (Field field: c.getDeclaredFields()) {
            System.out.println(field);
        }
        for(Method method : c.getDeclaredMethods()) {
            System.out.println(method);
        }

        try{
            Cat cat = (Cat)c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Class catClazz = Class.forName("com.africa.study.reflect.Cat");
            Field name = catClazz.getDeclaredField("name");
            name.setAccessible(true);
            Cat cat2 = (Cat) catClazz.newInstance();
            name.set(cat2, "Africa");
            System.out.println(name.get(cat2));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
