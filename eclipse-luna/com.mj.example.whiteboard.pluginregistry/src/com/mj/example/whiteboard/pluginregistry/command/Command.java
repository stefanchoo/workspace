package com.mj.example.whiteboard.pluginregistry.command;

import java.util.Optional;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.service.command.CommandProcessor;

import com.mj.example.whiteboard.pluginregistry.Plugin;
import com.mj.example.whiteboard.pluginregistry.Registry;

@Component(properties = {@Property(name = CommandProcessor.COMMAND_SCOPE, value = "command"),
        @Property(name = CommandProcessor.COMMAND_FUNCTION, value = {"man", "exec", "all"})}, provides = Object.class)
public class Command {

    @ServiceDependency
    private volatile Registry registry;

    public void man() {
        registry.listPlugins().stream()
            .map(Plugin::getName)
            .forEach(System.out::println);
    }

    public void exec(String name) {
        Optional<Plugin> plugin = registry.getPlugin(name);
        if(plugin.isPresent()) {
            plugin.get().execute();
        } else {
            System.out.println("Plugin not found");
        }
    }

    public void all() {
        registry.listPlugins().forEach(p -> p.execute());
    }
}