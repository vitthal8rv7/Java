package com.learn.java.spring.security.jwt.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learn.java.spring.security.jwt.model.document.User;

public interface UserService extends UserDetailsService {

//	@PreAuthorize("hasRole('ADMIN')") //if the requirement is service specific then apply here to interface 
									// else if the requirement is implementation specific then apply to implementation class
	public void registerUser(String userName, String password);

	public void testEnableMethodSecurity();

	public void preAuthorizeTest1();

	public void preAuthorizeTest2(String userName);

	public org.springframework.security.core.userdetails.User postAuthorizeTest1();

	public void secureMethod1();

	public void secureMethod2(String userName);

	public void preFilterTest1(List<String> asList);
	
	public void preFilterTest2(List<String> asList, List<String> asList2);

	public List<String> postFilterTest1(List<String> asList);

	public void threadLocal();

	public User getUser();

}
