package com.learn.java.spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.spring.security.jwt.model.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByUserNameIgnoreCase(String userName);
	
}
