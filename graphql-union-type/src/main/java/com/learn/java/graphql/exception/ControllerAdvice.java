package com.learn.java.graphql.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learn.java.graphql.model.ErrorResponse;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(FileNotFoundException.class) 
	@ResponseBody
	public ResponseEntity<ErrorResponse> fileNotFoundException() {
		System.out.println("Inside Exception Handler");
		ErrorResponse errorListResponse = new ErrorResponse("File Not Found Exception Demo");
		return new ResponseEntity<>(errorListResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArithmeticException.class) 
	@ResponseBody
	public ResponseEntity<ErrorResponse> arithmeticException() {
		System.out.println("Inside Arithmetic Exception Handler in controller advice");
		ErrorResponse errorListResponse = new ErrorResponse("Arithmetic Exception Demo");
		return new ResponseEntity<>(errorListResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
