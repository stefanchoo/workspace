package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/12/19
 */
public class Streams {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .sorted()                       // aaa2, aaa1 -> aaa1, aaa2
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

    }
}
