package com.learn.java.swagger2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Controller for Demo API", tags = {"Demo API1"})
public class DemoController {

   @ApiOperation(value = "Get a demo message", response = String.class, tags = {"Demo API1"})
   @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "Get a demo message2", response = String.class, tags = {"Demo API2"})
    @GetMapping("/message2")
    public ResponseEntity<String> getMessage2() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
}