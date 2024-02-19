package com.learn.java.mongodb.repository;

import java.util.Date;
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

	@Query("{ 'salary' : ?0 }")
	List<Employee> findBySalarySortedAndLimited(Float salary, Sort sort, Integer limit);

	@Query(value = "{ 'salary' : ?0 }", fields = "{ 'name': 1, 'salary': 1 }")
	List<Employee> findProjectedByNameAndSalary(Float salary);

	@Query("{ $or : [{ 'name' : ?0 }, { 'department' : ?0 }] }")
	List<Employee> findByNameOrDepartment(String keyword);

	@Query("{ 'name' : { $regex : ?0, $options: 'i' } }")
	List<Employee> findByNameRegex(String regex);

	@Query("{ 'name' : { $in : ?0 } }")
	List<Employee> findByNamesIn(List<String> names);

	@Query("{ 'addresses' : { $exists : ?0 } }")
	List<Employee> findByAddressesExists(boolean exists);

	@Query(value = "{ 'salary' : ?0 }", fields = "{ 'name': 1, 'department': 1 }")
	List<Employee> findProjectedByNameAndDepartment(Float salary, Sort sort);
//
//	@Query("{ $text : { $search : ?0 } }")
//	List<Employee> findByTextSearch(String keyword);
// Command failed with error 27 (IndexNotFound): 'text index required for $text query' 

	@Query("{ 'salary': { $gte: ?0, $lte: ?1 } }")
	List<Employee> findBySalaryBetweenEq(Float minSalary, Float maxSalary);

	@Query("{ $and : [{ 'salary' : ?0 }, { 'department' : ?1 }] }")
	List<Employee> findBySalaryAndDepartment(Float salary, String department);

	@Query("{ $or : [{ 'salary' : ?0 }, { 'salary' : ?1 }] }")
	List<Employee> findBySalary1OrSalary2(Float salary, Float salary2);

	@Query("{ 'salary' : { $ne : ?0 } }")
	List<Employee> findByNotMatchedSalary(Float salary);

	@Query("{ 'addresses' : { $size : ?0 } }")
	List<Employee> findByNumberOfAddresses(int size);

	@Query("{ 'addresses.city' : ?0 }")
	List<Employee> findByAddressesCity(String city);

	@Query("{ $or: [ { 'name': { $regex: ?0 } }, { 'department': { $regex: ?0 } } ] }")
	List<Employee> findByNameOrDepartmentRegex(String regex);

	@Query("{ 'addresses.city': { $all: ?0 } }")
	List<Employee> findByAddressesCities(List<String> cities);

	@Query("{ $nor: [ { 'salary': { $lt: ?0 } }, { 'salary': { $gt: ?1 } } ] }")
	List<Employee> findBySalaryBetweenUsingNor(Float minSalary, Float maxSalary);

	@Query("{ 'dateOfJoining' : { $lt : ?0 } }")
	List<Employee> findByJoiningDateBefore(Date date);

	@Query("{ 'dateOfJoining' : { $gte : ?0, $lte : ?1 } }")
    List<Employee> findByJoiningDateBetween(Date startDate, Date endDate);

	
	
	
}
