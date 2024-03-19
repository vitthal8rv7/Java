package com.learn.java.mysql.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name should not be null")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author author;
}
