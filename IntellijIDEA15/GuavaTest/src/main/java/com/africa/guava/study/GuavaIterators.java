package com.africa.guava.study;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaIterators {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("Apple","Pear","Peach","Banana");

        boolean allIsStartsWithP = Iterators.all(list.iterator(), p -> p.startsWith("P"));
        System.out.println("all result == " + allIsStartsWithP);

        boolean anyIsStartsWithP = Iterators.any(list.iterator(), p -> p.startsWith("P"));
        System.out.println("any result == " + anyIsStartsWithP);

        Iterators.filter(list.iterator(), p -> p.startsWith("P"))
                .forEachRemaining(c -> System.out.print("[" + c + "] "));

        String element = Iterators.get(list.iterator(), 1);
        System.out.println("\nget result : " + element);

        // 查询第一个满足要求的元素
        String result = Iterators.find(list.iterator(), c -> c.startsWith("A"));
        System.out.println("find result ：" + result);

        Iterators.transform(list.iterator(), c -> c.length()).forEachRemaining(c -> System.out.println(c));
    }
}
