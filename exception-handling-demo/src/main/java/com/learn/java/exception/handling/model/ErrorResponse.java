package com.learn.java.exception.handling.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String message;
	private String timestamp;
	private Throwable cause;
	public ErrorResponse(String message) {
		this.statusCode = 404;
		this.timestamp = new Date().toString();
		this.cause = null;
		this.message = message;
	}
	
	public ErrorResponse() {
	}

	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	public static ErrorResponse getErrorResponse(String message) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(404);
		errorResponse.setTimestamp(new Date().toString());
		errorResponse.setCause(null);
		errorResponse.setMessage(message);
		return errorResponse;
	}
	
	
}
