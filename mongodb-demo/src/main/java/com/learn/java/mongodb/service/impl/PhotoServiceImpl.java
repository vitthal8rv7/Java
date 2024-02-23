package com.learn.java.mongodb.service.impl;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learn.java.mongodb.collection.Photo;
import com.learn.java.mongodb.repository.dao.PhotoDaoRepository;
import com.learn.java.mongodb.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceImpl.class);

	@Autowired
	private PhotoDaoRepository photoDaoRepository;

	@Override
	public String addPhoto(MultipartFile image) {

		Photo photo = new Photo();
		photo.setTitle(image.getOriginalFilename());
		try {
			photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		} catch (IOException e) {
			LOGGER.error("Error occured while configuring/processing with image.");
			e.printStackTrace();
		}
		return photoDaoRepository.save(photo).getId();
	}

	@Override
	public Photo getPhoto(String imageId) {

		return photoDaoRepository.find(imageId);
	}

}
