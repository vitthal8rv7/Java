package com.learn.java.swagger2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Demo API", tags = {"Demo API"})
public class DemoController {

    @ApiOperation(value = "Get a demo message", response = String.class)
   @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
    
    
    @GetMapping("/message2")
    public ResponseEntity<String> getMessage2() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
}