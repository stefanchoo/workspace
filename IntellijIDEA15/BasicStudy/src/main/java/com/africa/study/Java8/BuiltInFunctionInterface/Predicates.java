package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Boolean Function, only one parameter
 * and or negate test
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Predicates {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<Object> nonNull = Objects::nonNull;
        Predicate<Object> isNull = Objects::isNull;

        System.out.println(nonNull.test("a"));
        System.out.println(isNull.test("a"));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isEmpty.test(""));
        System.out.println(isNotEmpty.test(""));
    }
}