package com.learn.java.graphql.annotation.util;

import com.learn.java.graphql.annotation.ValidateRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequestValidator implements ConstraintValidator<ValidateRequest,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Inside isvalid1");
		System.out.println("Inside isvalid2");
		return false;
	}

}
