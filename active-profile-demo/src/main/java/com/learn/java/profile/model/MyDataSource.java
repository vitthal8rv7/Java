package com.learn.java.profile.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class MyDataSource {

	String name;
	
	public MyDataSource() {
		name = "Default";
	}
	
	public MyDataSource(String profile) {
		name = profile;
	}

	@Override
	public String toString() {
		return "MyDataSource [name=" + name + "]";
	}
}
