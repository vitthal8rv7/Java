package com.learn.java.mapper.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = -471503570162062978L;
	
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
}
