package com.learn.java.junit5.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.junit5.collection.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {

}
