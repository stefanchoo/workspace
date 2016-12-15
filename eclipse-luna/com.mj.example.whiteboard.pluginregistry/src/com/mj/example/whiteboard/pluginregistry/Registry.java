package com.mj.example.whiteboard.pluginregistry;

import java.util.List;
import java.util.Optional;

public interface Registry {
    List<Plugin> listPlugins();
    Optional<Plugin> getPlugin(String name);   // since 1.8
}
