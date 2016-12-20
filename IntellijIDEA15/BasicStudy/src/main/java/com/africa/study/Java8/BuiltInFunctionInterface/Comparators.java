package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.Comparator;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Comparators {

    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "WonderfulLand");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }
}