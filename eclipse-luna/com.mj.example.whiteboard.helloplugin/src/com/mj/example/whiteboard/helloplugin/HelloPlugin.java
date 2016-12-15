package com.mj.example.whiteboard.helloplugin;

import org.apache.felix.dm.annotation.api.Component;

import com.mj.example.whiteboard.pluginregistry.Plugin;

@Component
public class HelloPlugin implements Plugin {

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void execute() {
        System.out.println("Hello, from the Hello Plugin！");
    }

}
