package com.learn.java.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multidb.entity.mysql.db1.UserDB1;
import com.learn.java.multidb.service.MultiDBService;

@RestController
@RequestMapping("/mysql/db1/demo")
public class MysqlDB1Controller {

	@Autowired
	private MultiDBService multiDBService;

	@GetMapping("/add")
	public UserDB1 addEntityToMultipleDatabases() {
		return multiDBService.addUserToDB1();
	}

	@GetMapping("/read")
	public UserDB1 readEntityFromMultipleDatabases() {
		return multiDBService.readUserToDB1();
	}

	@GetMapping("/update")
	public UserDB1 updateEntityFromMultipleDatabases() {
		return multiDBService.updateUserToDB1();
	}
}
