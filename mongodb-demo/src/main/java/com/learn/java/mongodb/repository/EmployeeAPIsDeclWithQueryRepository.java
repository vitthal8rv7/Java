package com.learn.java.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public interface EmployeeAPIsDeclWithQueryRepository extends MongoRepository<Employee, String> {

	// Fine By Salary in between given 2 values, less then ?, greater than ?
//	@Query(value = "{ 'salary': { $gt: ?0, $lt: ?1 } }") 
//	List<Employee> findBySalaryBetween(Float minSalary, Float maxSalary);

	// In Field, we can use 1 for show field and 0 for ignore/skip fields, but at a
	// time we can use only 1 to all fields which you want to show and remaining
	// fields automatically set to 0 and skip/ignore those fields from result set
	// same for 0. we can set only 0 to all mentioned fields to skip them from
	// result set, and rest will set to 1 and showed in result set

	// if you try to set some fields with 1 and some fields with 0, you will get
	// exception
//	@Query(value = "{ 'salary': { $gt: ?0, $lt: ?1 } }", fields = "{id: 1, name: 1, salary: 1}" ) 
//	List<Employee> findBySalaryBetween(Float minSalary, Float maxSalary);
	@Query(value = "{ 'salary': { $gt: ?0, $lt: ?1 } }", fields = "{id: 0, name: 0, salary:0}")
	List<Employee> findBySalaryBetween(Float minSalary, Float maxSalary);

//	This query retrieves users by their age using a parameter placeholder (?0).
	@Query("{ 'salary' : ?0 }")
	List<Employee> findBySalary(Float salary);

//	This query retrieves Employees by their name, department and salary using multiple parameter placeholders (?0, ?1).
	@Query("{ 'name' : ?0, 'department' : ?1, 'salary' : ?2 }")
	List<Employee> findByNameAndDepartmentAndSalary(String name, String department, Float salary);
	
	@Query("{ 'salary' : ?0 }")
	List<Employee> findBySalarySorted(Float salary, Sort sort);

	@Query("{ 'salary' : ?0 }")
	List<Employee> findBySalaryPagination(Float salary, Pageable pageable);
	
//	Use sorting capabilities on Pageable instead;
//	@Query("{ 'salary' : ?0 }")
//	List<Employee> findBySalaryPaginationSorted(Float salary, Pageable pageable, Sort sort);


}
