package com.learn.java.lombok.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonAutoDetect(getterVisibility=Visibility.NONE)
public class Employee implements Serializable{

	private static final long serialVersionUID = -484017562532535270L;

	private String id;
	
	private String name;

//	public String getId() {
//		return id;
//	}

//	public void setId(String id) {
//		this.id = id;
//	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
