package com.learn.java.security.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

	@PreAuthorize("hasRole('ADMIN')") //if the requirement is service specific then apply here to interface 
									// else if the requirement is implementation specific then apply to implementation class
	public void registerUser();

	public void testEnableMethodSecurity();

	public void preAuthorizeTest1();

	public void preAuthorizeTest2(String userName);
//
//	public void preAuthorizeTest3(String string, String string2);
//
//	public void preAuthorizeTest4(List<String> asList);
//
//	public void preAuthorizeTest5(List<String> asList, List<String> asList2);

}
