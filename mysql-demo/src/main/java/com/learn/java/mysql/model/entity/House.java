package com.learn.java.mysql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ownerName;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private ParkingSpace parking;

	public House(House house) {
		super();
		this.id = house.id;
		this.ownerName = house.ownerName;
		this.parking = house.parking;
	}
}