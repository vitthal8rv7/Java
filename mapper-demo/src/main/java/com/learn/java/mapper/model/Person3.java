package com.learn.java.mapper.model;

import java.io.Serializable;

public class Person3 implements Serializable {

	private static final long serialVersionUID = -4354640988846646179L;
	
	private Address5 address;

	private Name name;

	public Address5 getAddress() {
		return address;
	}

	public void setAddress(Address5 address) {
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person3 [address=" + address + ", name=" + name + "]";
	}
}
