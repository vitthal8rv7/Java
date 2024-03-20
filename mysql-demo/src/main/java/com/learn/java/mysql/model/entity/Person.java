package com.learn.java.mysql.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Person {

	@Id //@EmbeddedId     // for composite primary key
	private Name name;
	
	@Email(message = "please provide valid email address.")
	private String email;
}
