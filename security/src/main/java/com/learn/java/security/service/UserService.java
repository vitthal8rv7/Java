package com.learn.java.security.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

	@PreAuthorize("hasRole('ADMIN')") //if the requirement is service specific then apply here to interface 
									// else if the requirement is implementation specific then apply to implementation class
	public void registerUser();

	public void testEnableMethodSecurity();

	public void preAuthorizeTest1();

}
