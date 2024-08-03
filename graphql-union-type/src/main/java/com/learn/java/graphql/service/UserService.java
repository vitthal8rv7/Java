package com.learn.java.graphql.service;

import java.util.List;

import com.learn.java.graphql.model.User;

public interface UserService {

	public List<User> getUsers();

	public User updateUser(User user);

	public User deleteUser(String string);

}
