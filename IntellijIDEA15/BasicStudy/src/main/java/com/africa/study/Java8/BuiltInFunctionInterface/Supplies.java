package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.function.Supplier;

/**
 * No parameter input but return one Object
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Supplies {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        System.out.println(person);
    }
}
