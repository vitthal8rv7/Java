package com.learn.java.mysql.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {

	@JsonIgnore
	private Long id;
	
	@Builder.Default
	private Integer age = 0;
	
	private String name;
	
	private String email;

	private Double salary;
	private Date joiningDate;
	private Date createdAt;
	private Date updatedAt;
	
	public EmployeeDto(Long id, String name, Double salary, Date joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}
	
//	private String departmentId;	
//	private List<Address> addresses;

	

}
