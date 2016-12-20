package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.function.Consumer;

/**
 * operation at one input parameter
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Consumers {
    public static void main(String[] args) {
        Consumer<Person> greeter = person -> System.out.println("Hello, " + person.getFirstName());
        greeter.accept(new Person("Stefan", "Choo"));
    }
}
