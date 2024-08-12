package com.java.learning.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome Home";
    }
}
