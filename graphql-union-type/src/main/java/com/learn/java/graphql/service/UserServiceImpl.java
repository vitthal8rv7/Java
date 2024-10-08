package com.learn.java.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.User;

@Service
public class UserServiceImpl implements UserService {

	
	
//	@Autowired
//	private UserRepository UserRepository;
	
	User user = null;
	@Override
	public List<User> getUsers() {
		
		
		System.out.println("INSIDE getUsers");
		List<User> users = new ArrayList<>();
		users.add(new User("U1", "UserName1"));
		users.add(new User("U2", "UserName2"));
		return users;
	}
	
	@Cacheable(value = "ram")
	@Override
	public User getUser(String id) {
		
		if(user == null) {
			System.out.println("INSIDE getUsers");
			user = new User("id", "UserName1");
		}
		return user;
	}

	@CachePut(value = "ram")
	@Override
	public User updateUser(String id) {
		System.out.println("INSIDE updateUser");
		user.setName("name3");
		return user;
	}

	@CacheEvict(value = "ram")
	@Override
	public User deleteUser(String id) {
		System.out.println("INSIDE deleteUser");
		user = null;
		return user;
	}

}
