package com.africa.study.Java8.BuiltInFunctionInterface;

import lombok.Data;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
@Data
public class Person {
    private String firstName;
    private String lastName;

    public Person(){
        this.firstName = "Stefan";
        this.lastName = "Choo";
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
