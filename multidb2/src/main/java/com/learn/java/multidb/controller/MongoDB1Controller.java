package com.learn.java.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multidb.entity.mongodb.UserMongoDB;
import com.learn.java.multidb.service.MultiDBService;

@RestController
@RequestMapping({"/mongodb/db1/demo"})
public class MongoDB1Controller {

	@Autowired
	private MultiDBService multiDBService;

	@GetMapping("/add")
	public UserMongoDB addEntityToMultipleDatabases() {
		return multiDBService.addUserToMongoDB1();
	}

	@GetMapping("/read")
	public UserMongoDB readEntityFromMultipleDatabases() {
		return multiDBService.readUserFromMongoDB1();
	}

	@GetMapping("/update")
	public UserMongoDB updateEntityFromMultipleDatabases() {
		return multiDBService.updateUserFromMongoDB1();
	}
}
