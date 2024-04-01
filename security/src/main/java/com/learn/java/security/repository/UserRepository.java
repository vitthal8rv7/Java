package com.learn.java.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.security.model.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByUserNameIgnoreCase(String userName);
	
}
