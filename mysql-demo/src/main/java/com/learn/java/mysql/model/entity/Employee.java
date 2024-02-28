package com.learn.java.mysql.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Employee {

	@jakarta.persistence.Id
	private String employee_id;
	private String department_id;
	private String name;
	private Double salary;
	private Date hire_date;
}
