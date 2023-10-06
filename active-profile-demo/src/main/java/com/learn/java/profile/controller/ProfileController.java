package com.learn.java.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.profile.service.DataSourceService;

@RestController
@RequestMapping("/active-profile/demo")
public class ProfileController {

	@Autowired
	private DataSourceService dataSourceService;
	
	@GetMapping("/get-info")
	public String getInfo() {
		return dataSourceService.getInfo();
	}
	
}
