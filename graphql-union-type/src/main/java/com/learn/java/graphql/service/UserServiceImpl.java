package com.learn.java.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.User;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	private UserRepository UserRepository;
	
	@Cacheable(value = "userU2", keyGenerator = KeyGenerator)
	@Override
	public List<User> getUsers() {
		System.out.println("INSIDE getUsers");
		List<User> users = new ArrayList<>();
		users.add(new User("U1", "UserName1"));
		users.add(new User("U2", "UserName2"));
		return users;
	}

	@CachePut(value = "userU2", keyGenerator = "userSpecificKeyGenerator")
	@Override
	public User updateUser(User user) {
		System.out.println("INSIDE updateUser");
		return user;
	}

	@CacheEvict(value = "userU2", keyGenerator = "userSpecificKeyGenerator")
	@Override
	public User deleteUser(String id) {
		System.out.println("INSIDE deleteUser");
		return null;
	}

}
