package com.learn.java.mapper.model;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -6245047560637013213L;

	@JMap(attributes = {"lastName", "firstName"}, classes = {Person.class, Person.class })
	private String fullName;

	@JMap("address")
	private Address address;
	
	//@JMap(value = "address.city", classes = Address.class)
	@JMapAccessor(name = "address.city", get = "address.getCity", classes = Address.class)
	private String city;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
