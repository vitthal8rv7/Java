package com.learn.java.junit5.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTestApproach2 {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
    	url = String.format("http://localhost:%d/mongo/demo/", port);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() {
        Assertions.assertTrue(this.restTemplate.getForObject(url, String.class).contains("Running"));
    }
}