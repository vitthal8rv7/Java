package com.learn.java.mysql.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler {


//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ExceptionHandler(Exception.class)
//	@Override
//	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders httpHeader, HttpStatus httpStatus, WebRequest request) {
//		Map<String, Object> body = new LinkedHashMap<>();
//		body.put("timestamp", System.currentTimeMillis());
//		body.put("status", httpStatus.value());		
//		List<String> errors = ex.getBindingResult()
//								.getFieldErrors()
//								.stream()
//								.map(error -> error.getDefaultMessage())
//								.toList();
//		body.put("error", errors);
//		return new ResponseEntity<Object>(body, httpStatus);
//	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(Exception exception) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", System.currentTimeMillis());
		body.put("status", 500);	
		body.put("error", exception.getMessage());
		return new ResponseEntity<Object>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
