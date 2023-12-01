package com.learn.java.mapper.model;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -6245047560637013213L;

	@JMap("firstName")
	private String fullName;

//	@JMap("address.city")
//	private String city;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	@Override
//	public String toString() {
//		return "PersonDTO [fullName=" + fullName + ", city=" + city + "]";
//	}
}
