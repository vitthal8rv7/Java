package com.learn.java.mapper.model;

import java.io.Serializable;

public class Address7 implements Serializable {


	private static final long serialVersionUID = -5769265472980403400L;

	private String city;

	private String street;

	private Name name;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Address7 [city=" + city + ", street=" + street + ", name=" + name + "]";
	}
}
