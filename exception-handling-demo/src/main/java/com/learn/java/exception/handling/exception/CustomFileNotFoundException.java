package com.learn.java.exception.handling.exception;

import com.learn.java.exception.handling.model.ErrorResponse;

public class CustomFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorResponse errorResponse = new ErrorResponse();;
	
	public CustomFileNotFoundException() {
	}
	
	public CustomFileNotFoundException(String message) {
		errorResponse = ErrorResponse.getErrorResponse(message);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
