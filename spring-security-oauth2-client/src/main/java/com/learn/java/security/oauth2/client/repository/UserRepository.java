package com.learn.java.security.oauth2.client.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.java.security.oauth2.client.model.document.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUsername(String username);
}
