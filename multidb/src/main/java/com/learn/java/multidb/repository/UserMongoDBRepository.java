package com.learn.java.multidb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.multidb.model.collection.UserMongoDB;

@Repository
public interface UserMongoDBRepository extends MongoRepository<UserMongoDB, String> {

	public UserMongoDB findByUserNameIgnoreCase(String userName);

}
