package com.learn.java.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {

}
