package com.learn.java.mysql.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {

	private String employee_id;
	private String department_id;
	private String name;
	private Double salary;
	private Date hire_date;
}
