package com.learn.java.mysql.model.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@NamedNativeQueries({
		@NamedNativeQuery(
		name = "Employee.findBySalaryLessThan42000", 
		query = "SELECT * FROM Employee WHERE salary < 42000", 
		resultClass = Employee.class),
		@NamedNativeQuery(
		name = "Employee.findBySalaryGreaterThan42000", 
		query = "SELECT * FROM Employee WHERE salary > 42000", 
		resultClass = Employee.class)
})
@NamedQueries({
	@NamedQuery(
		name = "Employee.findByAgeLessThan24",
		query = "FROM Employee WHERE age < 24" 
	),
	@NamedQuery(
		name = "Employee.findByAgeGreaterThanEqualTo24",
		query = "FROM Employee WHERE age >= 24" 			
	)
})
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
	
	@Temporal(TemporalType.TIME)
	@CreationTimestamp
	@Column(name = "joining_date")
	private Date joiningDate;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false, updatable = true)
	private Date updatedAt;

//	@JsonIgnore
//	@org.springframework.data.annotation.Transient // Not Working
	@jakarta.persistence.Transient//Working	
 	private String gender;
	
	@ManyToOne
//	@JoinColumn(name = "dp_id")
	@JoinTable(
	        name = "employee_department",   // Name of the join table
	        joinColumns = @JoinColumn(name = "employee_id"),   // Foreign key column in the join table referencing Employee
	        inverseJoinColumns = @JoinColumn(name = "department_id")  // Foreign key column in the join table referencing Department
	    )
	private Department department;
}
