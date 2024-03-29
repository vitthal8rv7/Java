package com.learn.java.security.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.java.security.config.PropertyHolder;
import com.learn.java.security.model.entity.User;
import com.learn.java.security.repository.UserRepository;
import com.learn.java.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PropertyHolder propertyHolder;
	
	@Override
	public void registerUser() {
		String password = "pass@user@123";
		String salting = BCrypt.gensalt();
		String peppering = propertyHolder.getPeppering();
		
		password = passwordEncoder.encode(""+password+salting+peppering);
		
		User user = userRepository.save(User.builder()
				.userName("user_123")
				.roles(Arrays.asList("USER", "ADMIN"))
				.authorities(Arrays.asList("USER_READ", "ADMIN_READ", "USER_WRITE", "ADMIN_WRITE"))
				.password(password)
				.build());
		System.out.println("User: "+user);		
	}
}
