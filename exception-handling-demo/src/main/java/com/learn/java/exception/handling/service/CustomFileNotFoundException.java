package com.learn.java.exception.handling.service;

import java.util.Date;

public class CustomFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String message;
	private String timestamp;
	private Throwable cause;
	
	public CustomFileNotFoundException() {
		this.statusCode = 404;
		this.message = "CustomFileNotFoundException";
		this.timestamp = new Date().toString();
		this.cause = null;
	}
	
	public CustomFileNotFoundException(String message) {
		this.statusCode = 404;
		this.timestamp = new Date().toString();
		this.cause = null;
		this.message = message;
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
	

}
