package com.learn.java.mapper.model;

import java.io.Serializable;

public class PersonDTO4 implements Serializable {

	private static final long serialVersionUID = -6245047560637013213L;

	private Address7 address;

	public Address7 getAddress() {
		return address;
	}

	public void setAddress(Address7 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonDTO4 [address=" + address + "]";
	}
}
