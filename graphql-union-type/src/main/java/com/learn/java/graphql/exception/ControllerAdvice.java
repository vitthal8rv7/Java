package com.learn.java.graphql.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.learn.java.graphql.model.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

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
	

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
    	System.out.println("INSIDE EXCEPTION");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<String> handleConstraintViolationException(HandlerMethodValidationException ex) {
    	
    	System.out.println("INSIDE EXCEPTION"+ ex.getClass().getName());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleConstraintViolationException(RuntimeException ex) {
    	ex.printStackTrace();
    	System.out.println("INSIDE EXCEPTION");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
