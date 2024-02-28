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
	
	private String Email;

	private Double salary;
	private Date joiningDate;
	private Date createdAt;
	private Date updatedAt;
	
//	private String departmentId;	
//	private List<Address> addresses;
}
