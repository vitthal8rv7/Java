package com.learn.java.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	//Fine By Salary in between given 2 values, less then ?, greater than ?
	@Query(value = "{ 'salary': { $gt: ?0, $lt: ?1 } }" ) 
	List<Employee> findBySalaryBetween(Float minSalary, Float maxSalary);
	
	
}
