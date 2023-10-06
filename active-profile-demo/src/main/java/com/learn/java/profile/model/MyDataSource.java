package com.learn.java.profile.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class MyDataSource {

	String name;
	
	@Value("${JAVA_HOME:default-value}") //Not Fetching System Java_Home In MacAirBook
	private String javaHome;

	public MyDataSource() {
		name = "Default";
	}
	       
	public MyDataSource(String  profile) {
		name = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	@Override
	public String toString() {
		return "MyDataSource [name=" + name + ", javaHome=" + javaHome + "]";
	}
}
