package com.learn.java.mongodb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Employee findById(String id) {
		return mongoTemplate.findById(id, Employee.class);
	}

	public Employee save(Employee employee) {
		return mongoTemplate.save(employee);
	}

	public List<Employee> findAll() {
		return mongoTemplate.findAll(Employee.class);
	}

	public void deleteById(Employee employee) {
		mongoTemplate.remove(employee);
	}

}
