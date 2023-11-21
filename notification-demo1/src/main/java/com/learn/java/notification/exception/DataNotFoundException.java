package com.learn.java.notification.exception;

import com.learn.java.notification.model.ErrorResponse;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorResponse errorResponse = new ErrorResponse();;
	
	public DataNotFoundException() {
	}
	
	public DataNotFoundException(String message) {
		errorResponse = ErrorResponse.getErrorResponse(message);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
