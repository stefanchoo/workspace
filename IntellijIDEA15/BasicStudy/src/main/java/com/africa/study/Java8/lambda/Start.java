package com.africa.study.Java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Start {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        // old
        System.out.println("---> old <---");
        for (String a: oldSort(names)) {
            System.out.println(a);
        }

        // new
        System.out.println("---> new <---");
        newSort(names).forEach(System.out::println);

    }

    public static List<String> oldSort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        return list;
    }

    public static List<String> newSort(List<String> list) {
        Collections.sort(list, String::compareTo);
        return list;
    }
}
