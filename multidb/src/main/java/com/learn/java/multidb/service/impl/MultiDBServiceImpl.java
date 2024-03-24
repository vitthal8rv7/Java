package com.learn.java.multidb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.multidb.model.collection.UserMongoDB;
import com.learn.java.multidb.model.dto.UserDto;
import com.learn.java.multidb.model.entity.UserMysqlDB;
import com.learn.java.multidb.repository.UserMongoDBRepository;
import com.learn.java.multidb.repository.UserMysqlDBRepository;
import com.learn.java.multidb.service.MultiDBService;

@Service
public class MultiDBServiceImpl implements MultiDBService {

	@Autowired
	private UserMysqlDBRepository userMysqlDBRepo;
	
	@Autowired
	private UserMongoDBRepository userMongoDBRepo;

	@Override
	public UserDto addUser() {
		
		UserMongoDB userMongoDB = UserMongoDB.builder().userName("Ram123").build();
		userMongoDB = userMongoDBRepo.save(userMongoDB);
		
		UserMysqlDB userMysqlDB = UserMysqlDB.builder().id(userMongoDB.getId()).userName("Ram123").build();
		userMysqlDB = userMysqlDBRepo.save(userMysqlDB);
		
		UserDto userDto = UserDto.builder().userMysqlDB(userMysqlDB).userMongoDB(userMongoDB).build();
		return userDto;
	}

	@Override
	public UserDto readUser() {
		UserMongoDB userMongoDB = userMongoDBRepo.findByUserNameIgnoreCase("Ram123");
		UserMysqlDB userMysqlDB = userMysqlDBRepo.findByUserNameIgnoreCase("Ram123");
		UserDto userDto = UserDto.builder().userMysqlDB(userMysqlDB).userMongoDB(userMongoDB).build();
		return userDto;
	}

	@Override
	public UserDto updateUser() {
		UserDto userDto = readUser();
		UserMongoDB userMongoDB = userDto.getUserMongoDB();
		userMongoDB.setUserName("Ram17");
		userMongoDB = userMongoDBRepo.save(userMongoDB);
		UserMysqlDB userMysqlDB = userDto.getUserMysqlDB();
		userMysqlDB.setUserName("Ram17");
		userMysqlDB = userMysqlDBRepo.save(userMysqlDB);
		userDto.setUserMongoDB(userMongoDB);
		userDto.setUserMysqlDB(userMysqlDB);
		return userDto;
	}
}
