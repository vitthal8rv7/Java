package com.learn.java.mongodb.service;

import org.springframework.web.multipart.MultipartFile;

import com.learn.java.mongodb.collection.Photo;

public interface PhotoService {

	public String addPhoto(MultipartFile image);

	public Photo getPhoto(String imageId);

}
