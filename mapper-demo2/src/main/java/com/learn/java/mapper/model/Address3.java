package com.learn.java.mapper.model;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;

@Component
@JMapAccessor
public class Address3 {
	
	@JMap
	private String city;

	@JMap
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
