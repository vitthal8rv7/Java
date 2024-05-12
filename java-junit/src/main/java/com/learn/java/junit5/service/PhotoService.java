package com.learn.java.junit5.service;

import org.springframework.web.multipart.MultipartFile;

import com.learn.java.junit5.collection.Photo;

public interface PhotoService {

	public String addPhoto(MultipartFile image);

	public Photo getPhoto(String imageId);

}
