package com.learn.java.mongodb.collection;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -1338319804176352106L;

	@Id
	private String id;
	private String name;
	private String department;
	private List<Address> address;
	private Float salary; 
}
