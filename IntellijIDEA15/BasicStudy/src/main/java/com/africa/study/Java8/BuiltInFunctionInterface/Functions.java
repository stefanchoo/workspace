package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.function.Function;

/**
 *  input one parameter and return one parameter
 *
 *  could combine several methods with compose, andThen
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Functions {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        // before.andThen(after) return after
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        Function<String, String> appendOne = a -> a + "1";
        // after.compose(before) return after
        Function<String, Integer> appendOneAndToInteger = toInteger.compose(appendOne);

        int a = toInteger.apply("123");
        String b = backToString.apply("123");

        int c = appendOneAndToInteger.apply("123");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
