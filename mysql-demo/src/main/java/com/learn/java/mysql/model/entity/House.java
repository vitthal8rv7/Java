package com.learn.java.mysql.model.entity;

import java.io.Serializable;

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
public class House implements Serializable {

	private static final long serialVersionUID = -9122332886908734874L;

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
	
	public House(Integer id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}
}