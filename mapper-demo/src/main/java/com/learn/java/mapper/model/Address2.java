package com.learn.java.mapper.model;

import org.springframework.stereotype.Component;

@Component
public class Address2 {

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
