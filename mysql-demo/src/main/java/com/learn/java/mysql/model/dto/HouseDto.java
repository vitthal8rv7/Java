package com.learn.java.mysql.model.dto;

import java.io.Serializable;

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
	
//	public HouseDto(Integer id, String ownerName) {
//		this.id = id;
//		this.ownerName = ownerName;
//	}
}