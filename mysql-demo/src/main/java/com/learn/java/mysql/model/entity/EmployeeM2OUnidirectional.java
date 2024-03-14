package com.learn.java.mysql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class EmployeeM2OUnidirectional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Employee name should not be null")
	private String name;
	
//	@JoinColumn(name = "department_id")
//	@JoinTable(
//	        name = "employee_department",   // Name of the join table
//	        joinColumns = @JoinColumn(name = "employee_id"),   // Foreign key column in the join table referencing Employee
//	        inverseJoinColumns = @JoinColumn(name = "department_id")  // Foreign key column in the join table referencing Department
//	    )
	@ManyToOne
	private DepartmentM2OUnidirectional department;
}
