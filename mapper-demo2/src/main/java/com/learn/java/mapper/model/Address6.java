package com.learn.java.mapper.model;

import java.io.Serializable;

public class Address6 implements Serializable {


	private static final long serialVersionUID = -5769265472980403400L;

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
		return "Address6 [city=" + city + ", street=" + street + "]";
	}
}
