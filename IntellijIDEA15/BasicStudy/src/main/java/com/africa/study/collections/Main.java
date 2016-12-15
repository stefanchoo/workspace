package com.africa.study.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/10/20
 */
public class Main {
    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("A1");
        A.add("A2");
        A.add("A3");

        List<String> B = new ArrayList<>();
        B.add("B1");
        B.add("B2");
        B.add("B3");

        A.addAll(B);

        System.out.println(A);

    }
}
