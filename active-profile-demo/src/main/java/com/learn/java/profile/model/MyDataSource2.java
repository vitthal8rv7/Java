package com.learn.java.profile.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class MyDataSource2 {

	String name;
      
	public MyDataSource2(@Value("${profile}")String  profile) {
		name = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyDataSource [name=" + name + "]";
	}
}
