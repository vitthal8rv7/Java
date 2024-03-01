package com.learn.java.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.java.mysql.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public Employee findOneByNameIs(String name);

	public List<Employee> findByNameIs(String name);
		
	public List<Employee> findByNameIsNot(String name);

	public List<Employee> findByNameEquals(String name);
	
	public List<Employee> findByNameContaining(String name);
	
	public List<Employee> findByNameContains(String name);
	
	public List<Employee> findByNameIgnoreCase(String name);
	
	public List<Employee> findByNameIgnoringCase(String name);
	
//	IsEmpty / IsNotEmpty can only be used on collection properties
//	public List<Employee> findByNameEmpty();
	
	public List<Employee> findByNameEndingWith(String regex);
	
	public List<Employee> findByNameEndsWith(String regex);
	
	public List<Employee> findByNameStartingWith(String regex);
	
	public List<Employee> findByNameStartsWith(String regex);
	
//	Unsupported keyword REGEX (1): [MatchesRegex, Matches, Regex]
//	public List<Employee> findByNameRegex(String regex);
	
	public List<Employee> findByNameIn(List<String> names);
	
	public List<Employee> findByNameOrderByAgeDesc(String name);
	
	public List<Employee> findByNameIsNotAndAgeLessThan(String name, Integer age);
	
	public List<Employee> findByNameIsNotAndAgeLessThanEqual(String name, Integer age);
	
	public List<Employee> findByNameIsNotAndAgeGreaterThan(String name, Integer age);
	
	public List<Employee> findByNameIsNotAndAgeGreaterThanEqual(String name, Integer age);
	
	public List<Employee> findByNameIsNotOrAgeGreaterThanEqualOrderByNameDesc(String name, Integer age);	
	
	public List<Employee> findByNameInAndAgeBetween(List<String> names, Integer lowerAgeLimit, Integer upperAgeLimit);
	
	public List<Employee> findByNameAndEmailInAllIgnoreCase(String name, List<String> emails);
}
