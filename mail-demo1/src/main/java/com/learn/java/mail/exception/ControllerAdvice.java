package com.learn.java.mail.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.learn.java.mail.model.ErrorResponse;

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
	
//	@ExceptionHandler(BadRequest.class) 
//	@ResponseBody
//	public ResponseEntity<ErrorResponse> badRequest() {
//		System.out.println("Inside Bad Request Exception Handler in controller advice");
//		ErrorResponse errorListResponse = new ErrorResponse("BadRequest Exception Demo");
//		return new ResponseEntity<>(errorListResponse, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(BadRequest.class) 
	@ResponseBody
	public ResponseEntity<ErrorResponse> badRequestWithParam(String message) {
		System.out.println("Inside Bad Request Exception Handler in controller advice");
		ErrorResponse errorListResponse = new ErrorResponse(message);
		return new ResponseEntity<>(errorListResponse, HttpStatus.BAD_REQUEST);
	}
}
