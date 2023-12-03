package com.learn.java.mapper.model;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = -9001430598967812110L;

	private String city;

	private String zipCode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", zipCode=" + zipCode + "]";
	}
}
