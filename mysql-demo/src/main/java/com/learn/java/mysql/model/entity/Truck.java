package com.learn.java.mysql.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode(callSuper=false)
@Entity
//@DiscriminatorValue("big_vehicle") //uncomment when you want to use DiscriminatorValue in InheritanceType.SINGLE_TABLE
public class Truck extends Vehicle {

	private Integer topSpeed;
	
	private Integer payloadCapacity;

	public Truck(String manufacturer, Integer topSpeed, Integer payloadCapacity) {
		super(manufacturer);
		this.topSpeed = topSpeed;
		this.payloadCapacity = payloadCapacity;
	}
}
