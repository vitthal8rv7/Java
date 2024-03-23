package com.learn.java.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multidb.model.dto.UserDto;
import com.learn.java.multidb.service.MultiDBService;

@RestController
@RequestMapping("/multi-db/demo")
public class MysqlController {

	@Autowired
	private MultiDBService multiDBService;
	
	@GetMapping("/add")
	public UserDto addEntityToMultipleDatabases() {
		return multiDBService.addUser();
	}

	@GetMapping("/read")
	public UserDto readEntityFromMultipleDatabases() {
		return multiDBService.readUser();
	}

}
