package com.learn.java.mapper.model;

import java.io.Serializable;

public class Person4 implements Serializable {

	private static final long serialVersionUID = -4354640988846646179L;

	private Address5 address2;

	private Address5 address1;

	private Name name;

	public Address5 getAddress1() {
		return address1;
	}

	public void setAddress1(Address5 address) {
		this.address1 = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address5 getAddress2() {
		return address2;
	}

	public void setAddress2(Address5 address2) {
		this.address2 = address2;
	}

	@Override
	public String toString() {
		return "Person4 [address1=" + address1 + ", address2=" + address2 + ", name=" + name + "]";
	}


}
