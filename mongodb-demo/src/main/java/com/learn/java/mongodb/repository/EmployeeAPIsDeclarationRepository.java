package com.learn.java.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public interface EmployeeAPIsDeclarationRepository extends MongoRepository<Employee, String> {

	// Declare APIs to access Data by one field
	List<Employee> findByName(String name);

	List<Employee> findByNameIn(List<String> name);

	List<Employee> findByNameIsNotIn(List<String> name);

	Employee findFirstByName(String name);

	Employee findTopByName(String name);

	List<Employee> findDistinctByName(String name); // Fetch Distinct entities if duplicate found

	Employee findFirstByNameOrderByNameDesc(String name);

	Employee findFirstByNameOrderByIdDesc(String name);

	Employee findFirstByNameIgnoreCaseOrderByIdDesc(String name);

	List<Employee> findByNameIgnoreCase(String name);

	List<Employee> findByNameIgnoreCaseEndsWith(String name);

	List<Employee> findByNameIgnoreCaseStartsWith(String name);

	Employee findFirstByNameIgnoreCaseStartsWith(String name);

	Employee findFirstByNameIsNotIgnoreCase(String name);

	List<Employee> findAllByNameIsNotIgnoreCase(String name);

	Integer countByName(String name);

	Integer countByNameContaining(String name);

	List<Employee> findByNameContaining(String name);

	List<Employee> findByNameRegex(String name);

//	List<Employee> findByNames(List<String> names);
//	List<Employee> findFirstByNameIsNotIgnoreCaseStartsWith(String name);
//	List<Employee> findFirstByNameIgnoreCaseStartsWithIsNot(String name, String name2);
	// Error creating bean
//	Employee findOneByName(String name); // Exception saying => returned non unique result

	List<Employee> findByDepartment(String department);

	Employee findFirstByDepartment(String department);
//	Employee findLastByDepartment(String department); // Exception saying => returned non unique result 

	// Declare APIs to access Data by more than one field
//	List<Employee> findByNameNullOrDepartment(String name, String deparment);
	List<Employee> findByNameOrDepartment(String name, String deparment);

	List<Employee> findByNameAndDepartment(String name, String deparment);

	List<Employee> findByNameInAndDepartment(List<String> name, String deparment);

	Employee findFirstByNameAndDepartmentAllIgnoreCaseOrderByIdDesc(String name, String deparment);

//	List<Employee> findByEmployee_Addresses_CityIn(String city);
	List<Employee> findByAddresses_CityIn(String city);

	List<Employee> findByAddresses_CityAndAddresses_Address1(String city, String address1);

	List<Employee> findByNameAndAddresses_CityAndAddresses_Address1(String name, String city, String address1);
}
