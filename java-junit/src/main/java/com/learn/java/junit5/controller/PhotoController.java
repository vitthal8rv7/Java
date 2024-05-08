package com.learn.java.junit5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.java.junit5.collection.Photo;
import com.learn.java.junit5.service.PhotoService;

@RestController
@RequestMapping("/mongo/demo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	@PostMapping("/photo")
	public String addPhoto(@RequestParam("image") MultipartFile image) {

		return photoService.addPhoto(image);
	}

	@GetMapping("/photo/{id}")
	public ResponseEntity<Resource> getPhoto(@PathVariable String id) {

		Photo photo = photoService.getPhoto(id);
		Resource resource = new ByteArrayResource(photo.getPhoto().getData());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ photo.getTitle() + "\"")
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);

	}

}
