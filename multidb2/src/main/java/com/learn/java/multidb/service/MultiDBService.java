package com.learn.java.multidb.service;

import com.learn.java.multidb.entity.mongodb.UserMongoDB;
import com.learn.java.multidb.entity.mysql.db1.UserDB1;
import com.learn.java.multidb.entity.mysql.db2.UserDB2;

public interface MultiDBService {

	public UserDB1 addUserToDB1();

	public UserDB1 readUserToDB1();

	public UserDB1 updateUserToDB1();

	public UserDB2 addUserToDB2();

	public UserDB2 readUserToDB2();

	public UserDB2 updateUserToDB2();

	public UserMongoDB addUserToMongoDB1();

	public UserMongoDB readUserFromMongoDB1();

	public UserMongoDB updateUserFromMongoDB1();
	
	public UserMongoDB addUserToMongoDB2();

	public UserMongoDB readUserFromMongoDB2();

	public UserMongoDB updateUserFromMongoDB2();
}
