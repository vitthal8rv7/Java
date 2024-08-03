package com.learn.java.graphql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.learn.java.graphql.annotation.util.RequestValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
@Constraint(validatedBy = {RequestValidator.class})
public @interface ValidateRequest {

	public String message() default "invalid request";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
