package com.africa.guava.study;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * 一键多值
 * Map<String, Collection<String>>
 *
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaMultimaps {
    public static void main(String[] args) {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        // 添加键值对
        myMultimap.put("Fruits", "Bannana");
        //给Fruits元素添加另一个元素
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // 获得multimap的size  : 数量上还是4个！
        int size = myMultimap.size();
        System.out.println(size);  // 4

        // 获得Fruits对应的所有的值
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        myMultimap.values().forEach(m -> System.out.println(m));

        // Removing a single value
        myMultimap.remove("Fruits","Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
    }
}
