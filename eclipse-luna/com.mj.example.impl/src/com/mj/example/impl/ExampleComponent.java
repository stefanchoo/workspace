package com.mj.example.impl;

import org.apache.felix.dm.annotation.api.Component;

import com.mj.example.api.Greeting;


@Component
public class ExampleComponent implements Greeting {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public String anwserFrom(String name, String words) {
		return name + " say : " + words;
	}

}
