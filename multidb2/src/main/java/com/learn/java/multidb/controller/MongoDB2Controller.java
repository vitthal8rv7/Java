package com.learn.java.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multidb.entity.mongodb.UserMongoDB;
import com.learn.java.multidb.service.MultiDBService;

@RestController
@RequestMapping({"/mongodb/db2/demo"})
public class MongoDB2Controller {

	@Autowired
	private MultiDBService multiDBService;

	@GetMapping("/add")
	public UserMongoDB addEntityToMultipleDatabases() {
		return multiDBService.addUserToMongoDB2();
	}

	@GetMapping("/read")
	public UserMongoDB readEntityFromMultipleDatabases() {
		return multiDBService.readUserFromMongoDB2();
	}

	@GetMapping("/update")
	public UserMongoDB updateEntityFromMultipleDatabases() {
		return multiDBService.updateUserFromMongoDB2();
	}
}
