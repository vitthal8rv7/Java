package com.learn.java.mail.exception;

import com.learn.java.mail.model.ErrorResponse;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorResponse errorResponse = new ErrorResponse();;
	
	public InternalServerErrorException() {
	}
	
	public InternalServerErrorException(String message) {
		errorResponse = ErrorResponse.getErrorResponse(message);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
