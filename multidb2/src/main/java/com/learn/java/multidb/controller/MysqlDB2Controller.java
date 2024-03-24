package com.learn.java.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multidb.entity.mysql.db2.UserDB2;
import com.learn.java.multidb.service.MultiDBService;

@RestController
@RequestMapping("/mysql/db2/demo")
public class MysqlDB2Controller {

	@Autowired
	private MultiDBService multiDBService;

	@GetMapping("/add")
	public UserDB2 addEntityToMultipleDatabases() {
		return multiDBService.addUserToDB2();
	}

	@GetMapping("/read")
	public UserDB2 readEntityFromMultipleDatabases() {
		return multiDBService.readUserToDB2();
	}

	@GetMapping("/update")
	public UserDB2 updateEntityFromMultipleDatabases() {
		return multiDBService.updateUserToDB2();
	}
}
