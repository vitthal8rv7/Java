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

//Set to all APIs in this controller
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "DemoController2: Successfully retrieved message"),
        @ApiResponse(code = 401, message = "DemoController2: You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "DemoController2: Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "DemoController2: The resource you were trying to reach is not found")
})
@RestController
@RequestMapping("/api")
@Api(value = "Demo API", tags = {"Demo API"})
public class DemoController2 {

    @ApiOperation(value = "Get a demo message", response = String.class)
   @GetMapping("/message3")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
   
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DemoController2.1: Successfully retrieved message"),
            @ApiResponse(code = 401, message = "DemoController2.1: You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "DemoController2.1: Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "DemoController2.1: The resource you were trying to reach is not found")
    })    
    @GetMapping("/message4")
    public ResponseEntity<String> getMessage2() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
}