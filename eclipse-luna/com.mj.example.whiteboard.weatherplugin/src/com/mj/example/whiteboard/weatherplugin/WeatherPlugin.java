package com.mj.example.whiteboard.weatherplugin;

import org.apache.felix.dm.annotation.api.Component;

import com.mj.example.whiteboard.pluginregistry.Plugin;

@Component
public class WeatherPlugin implements Plugin {

    @Override
    public String getName() {
        return "weather";
    }

    @Override
    public void execute() {
        System.out.println("few clouds");
    }

}
