package com.learn.java.mysql.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Car extends Vehicle {

	private Integer topSpeed;
	
    private String sunroof;

	public Car(String manufacturer, Integer topSpeed, String sunroof) {
		super(manufacturer);
		this.topSpeed = topSpeed;
		this.sunroof = sunroof;
	}

}
