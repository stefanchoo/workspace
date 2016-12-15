package com.mj.example.hello.impl;

import org.apache.felix.dm.annotation.api.Component;

import com.mj.example.api.Greeting;

@Component
public class HelloImpl implements Greeting {

    @Override
    public String sayHello(String name) {
        return "Hello, I am the " + this.getClass().getName();
    }

    @Override
    public String anwserFrom(String name, String words) {
        return null;
    }

}
