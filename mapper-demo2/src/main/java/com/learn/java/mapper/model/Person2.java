package com.learn.java.mapper.model;

import java.io.Serializable;

public class Person2 implements Serializable {

	private static final long serialVersionUID = -4354640988846646179L;
	
	private Address5 address;

	public Address5 getAddress() {
		return address;
	}

	public void setAddress(Address5 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + "]";
	}
}
