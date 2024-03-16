package com.learn.java.mysql.model.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Vehicle_Type")

//@Inheritance(strategy = InheritanceType.JOINED)

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	// MappingException: Cannot use identity column key generation with <union-subclass> mapping for
	//do not GenerationType.IDENTITY with InheritanceType.TABLE_PER_CLASS
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String manufacturer;

	public Vehicle(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}





