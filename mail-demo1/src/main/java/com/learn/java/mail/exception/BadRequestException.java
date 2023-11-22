package com.learn.java.mail.exception;

import com.learn.java.mail.model.ErrorResponse;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorResponse errorResponse = new ErrorResponse();;
	
	public BadRequestException() {
	}
	
	public BadRequestException(String message) {
		errorResponse = ErrorResponse.getErrorResponse(message);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
