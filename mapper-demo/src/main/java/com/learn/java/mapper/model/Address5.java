package com.learn.java.mapper.model;

import java.io.Serializable;

public class Address5 implements Serializable {

	private static final long serialVersionUID = -2699138881950495180L;

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
		return "Address4 [city=" + city + ", street=" + street + "]";
	}
}
