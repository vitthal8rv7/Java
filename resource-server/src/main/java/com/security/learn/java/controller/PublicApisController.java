package com.security.learn.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicApisController {

    @GetMapping("/notices")
    public String notices() {
        return "notices";
    }
}
