package com.learn.java.mysql.model.dto;

import java.io.Serializable;

import com.learn.java.mysql.model.entity.ParkingSpace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Data
@Builder
public class HouseDto implements Serializable {

	private static final long serialVersionUID = -9122332886908734874L;

	private Integer id;

	private Long number;

	private String ownerName;
	
	private ParkingSpaceDto parking;

	public HouseDto(String ownerName) {
		this.ownerName = ownerName;
	}

	public HouseDto(Long number, String ownerName) {
		super();
		this.number = number;
		this.ownerName = ownerName;
	}

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