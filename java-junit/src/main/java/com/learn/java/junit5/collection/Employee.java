package com.learn.java.junit5.collection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "employee")
@CompoundIndexes({ @CompoundIndex(name = "customIndex", def = "{'name' : 1, 'department': 1}") })
public class Employee implements Serializable {

	private static final long serialVersionUID = -1338319804176352106L;

	@Id
	private String id;

	private String name;

	// It's used to indicate that a particular property of a Java class should be
	// ignored during JSON (de)serialization.
//	@JsonIgnore
	private String department;

	/*
	 * It is used for JSON serialization and deserialization. It allows you to
	 * customize the name of a property in the JSON representation, providing more
	 * control over the mapping between Java objects and JSON.
	 */
	// change field name addresses to address in response view

	@JsonProperty("address")
	private List<Address> addresses;

	/*
	 * It is used for JSON serialization and deserialization. It is used to annotate
	 * a method (typically a setter method) to be used during deserialization to set
	 * the value of a property from JSON.
	 */
	// change field name salary to sal in response view
//	@JsonSetter("sal")
	private Float salary;
	
	private Date dateOfJoining;
}
