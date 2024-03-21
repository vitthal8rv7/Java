package com.learn.java.mysql.model.dto;

import java.io.Serializable;

import com.learn.java.mysql.model.entity.ParkingSpace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseDto implements Serializable {

	private static final long serialVersionUID = -9122332886908734874L;

	private Integer id;
	
	private String ownerName;
	
	private ParkingSpaceDto parking;

	public HouseDto(Integer id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}
	
	public HouseDto(Integer id, String ownerName, ParkingSpace parking) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.parking = new ParkingSpaceDto(parking.getId(), parking.getParkingName());
	}
}