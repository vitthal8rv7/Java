package com.learn.java.mongodb.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Photo;

@Repository
public class PhotoDaoRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Photo save(Photo photo) {
		return mongoTemplate.save(photo);

	}

	public Photo find(String imageId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(imageId));
		return mongoTemplate.findOne(query, Photo.class);
	}
}
