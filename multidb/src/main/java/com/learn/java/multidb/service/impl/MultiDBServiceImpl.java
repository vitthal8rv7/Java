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
}
