package com.mj.tutorial.todo.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.felix.dm.annotation.api.Component;


@Path("todo")
@Component(provides = Object.class)
public class TodoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> list() {
        return Arrays.asList("A", "B", "C");
    }
}
