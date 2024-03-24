package com.learn.java.multidb.service;

import com.learn.java.multidb.model.dto.UserDto;

public interface MultiDBService {

	public UserDto addUser();

	public UserDto readUser();

	public UserDto updateUser();

}
