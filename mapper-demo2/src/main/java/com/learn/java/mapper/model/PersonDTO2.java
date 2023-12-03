package com.learn.java.mapper.model;

import java.io.Serializable;

public class PersonDTO2 implements Serializable {

	private static final long serialVersionUID = -6245047560637013213L;

	private String city;

	private String street;

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

	@Override
	public String toString() {
		return "PersonDTO2 [city=" + city + ", street=" + street + "]";
	}
}
