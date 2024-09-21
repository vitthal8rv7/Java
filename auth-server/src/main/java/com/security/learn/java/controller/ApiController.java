package com.security.learn.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/private")
    public String privateMethod() {
        return "private";
    }
}
