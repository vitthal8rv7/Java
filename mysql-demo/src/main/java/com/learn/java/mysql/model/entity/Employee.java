package com.learn.java.mysql.model.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@NamedNativeQuery(
		name = "Employee.findBySalaryLessThan42000", 
		query = "SELECT * FROM Employee WHERE salary < 42000", 
		resultClass = Employee.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Builder.Default
	private Integer age = 0;
	
	@NotBlank(message = "Employee name should not be null")
	private String name;
	
	private Double salary;
	
	@NotBlank(message = "Employee`s email should not be null")
	@Email(message = "Please enter the valid email address.")
	private String email;
	
	@CreationTimestamp
	@Column(name = "joining_date")
	private Date joiningDate;

	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false, updatable = true)
	private Date updatedAt;
	

//	@ForeignKey
//	private String departmentId;
	
//	private List<Address> addresses;

}
