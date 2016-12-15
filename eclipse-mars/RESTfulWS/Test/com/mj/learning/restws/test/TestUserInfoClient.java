package com.mj.learning.restws.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserInfoClient {

  public static final String BASE_URI = "http://localhost:8080/RESTfulWS/rest";
  public static final String PATH_NAME = "/UserInfoService/name/";
  public static final String PATH_AGE = "/UserInfoService/age/";
  private String name = "Stefan";
  private int age = 24;
  
  private Client client;
  private WebTarget webTarget;

  @Before
  public void setUp() throws Exception {
    System.out.println("====== Client begins ======");
    client = ClientBuilder.newClient();
    webTarget = client.target(BASE_URI);
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("====== Client ends ======" + "\n" );
  }

  @Test
  public void testGetName() {
    System.out.println("  ---- Get Name ---- ");
    WebTarget nameTarget = webTarget.path(PATH_NAME + name);
    Invocation.Builder invocationBuilder =
        nameTarget.request(MediaType.TEXT_XML);
    invocationBuilder.header("some-header", "true");
    Response response = invocationBuilder.get();
    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));
  }
  
  @Test
  public void testGetAge() {
    System.out.println("  ---- Get Age ---- ");
    WebTarget ageTarget = webTarget.path(PATH_NAME + age);
    Invocation.Builder invocationBuilder =
        ageTarget.request(MediaType.TEXT_XML);
    invocationBuilder.header("some-header", "true");
    Response response = invocationBuilder.get();
    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));
  }
}
