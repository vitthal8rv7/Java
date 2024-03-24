package com.learn.java.multidb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.learn.java.multidb.entity.mongodb.UserMongoDB;
import com.learn.java.multidb.entity.mysql.db1.UserDB1;
import com.learn.java.multidb.entity.mysql.db2.UserDB2;
import com.learn.java.multidb.repository.mysql.db1.UserDB1Repository;
import com.learn.java.multidb.repository.mysql.db2.UserDB2Repository;
import com.learn.java.multidb.service.MultiDBService;

@Service
public class MultiDBServiceImpl implements MultiDBService {

	@Autowired
	private UserDB1Repository userDB1Repo;

	@Autowired
	private UserDB2Repository userDB2Repo;

	@Autowired
	private MongoTemplate mongoTemplate1;

	@Autowired
	private MongoTemplate mongoTemplate2;

	@Override
	public UserDB1 addUserToDB1() {
		return userDB1Repo.save(UserDB1.builder().id(1L).userName("1A17DB1").build());
	}

	@Override
	public UserDB1 readUserToDB1() {
		return userDB1Repo.findByUserNameIgnoreCase("1A17DB1");
	}

	@Override
	public UserDB1 updateUserToDB1() {
		UserDB1 user = userDB1Repo.findByUserNameIgnoreCase("1A17DB1");
		user.setUserName("11A17DB1");
		return userDB1Repo.save(user);
	}

	@Override
	public UserDB2 addUserToDB2() {
		return userDB2Repo.save(UserDB2.builder().id(1L).userName("1A17DB2").build());
	}

	@Override
	public UserDB2 readUserToDB2() {
		return userDB2Repo.findByUserNameIgnoreCase("1A17DB2");
	}

	@Override
	public UserDB2 updateUserToDB2() {
		UserDB2 user = userDB2Repo.findByUserNameIgnoreCase("1A17DB2");
		user.setUserName("11A17DB2");
		return userDB2Repo.save(user);
	}

	@Override
	public UserMongoDB addUserToMongoDB1() {
		return mongoTemplate1.save(UserMongoDB.builder().userName("1A17MDB1").build());
	}

	@Override
	public UserMongoDB readUserFromMongoDB1() {
		Query query = null;
		query = new Query(Criteria.where("userName").is("1A17MDB1"));
		return mongoTemplate1.findOne(query, UserMongoDB.class);
	}

	@Override
	public UserMongoDB updateUserFromMongoDB1() {
		Query query = null;
		query = new Query(Criteria.where("userName").is("1A17MDB1"));
		UserMongoDB user = mongoTemplate1.findOne(query, UserMongoDB.class);
		user.setUserName("11A17DB2");
		return mongoTemplate1.save(user);
	}

	@Override
	public UserMongoDB addUserToMongoDB2() {
		return mongoTemplate2.save(UserMongoDB.builder().userName("1A17MDB1").build());
	}

	@Override
	public UserMongoDB readUserFromMongoDB2() {
		Query query = null;
		query = new Query(Criteria.where("userName").is("1A17MDB1"));
		return mongoTemplate2.findOne(query, UserMongoDB.class);
	}

	@Override
	public UserMongoDB updateUserFromMongoDB2() {
		Query query = null;
		query = new Query(Criteria.where("userName").is("1A17MDB1"));
		UserMongoDB user = mongoTemplate2.findOne(query, UserMongoDB.class);
		user.setUserName("11A17DB2");
		return mongoTemplate2.save(user);
	}

}
