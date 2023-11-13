package com.learn.java.micrometer.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 4932293854688566815L;

	private String id;

	private String name;

	public Employee() {

	}

	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
