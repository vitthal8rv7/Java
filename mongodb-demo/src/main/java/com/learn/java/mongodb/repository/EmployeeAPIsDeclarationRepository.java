package com.learn.java.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;


@Repository
public interface EmployeeAPIsDeclarationRepository extends MongoRepository<Employee, String> {
	
	//Declare APIs to access Data by one field
	List<Employee> findByName(String name);
	Employee findFirstByName(String name);
	Employee findFirstByNameOrderByNameDesc(String name);
	Employee findFirstByNameOrderByIdDesc(String name);
	Employee findFirstByNameIgnoreCaseOrderByIdDesc(String name);
	List<Employee> findByNameIgnoreCase(String name);
	List<Employee> findByNameIgnoreCaseEndsWith(String name);
	List<Employee> findByNameIgnoreCaseStartsWith(String name);
	Employee findFirstByNameIgnoreCaseStartsWith(String name);
	Employee findFirstByNameIsNotIgnoreCase(String name);
	List<Employee> findAllByNameIsNotIgnoreCase(String name);
	
	
//	List<Employee> findByNames(List<String> names);
//	List<Employee> findFirstByNameIsNotIgnoreCaseStartsWith(String name);
//	List<Employee> findFirstByNameIgnoreCaseStartsWithIsNot(String name, String name2);
	// Error creating bean
//	Employee findOneByName(String name); // Exception saying => returned non unique result

	List<Employee> findByDepartment(String department);
	Employee findFirstByDepartment(String department);
//	Employee findLastByDepartment(String department); // Exception saying => returned non unique result 
	

	  
	
	//Declare APIs to access Data by more than one field

}
