package com.learn.java.mongodb.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public class EmployeeRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);

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

	public Long delete(Employee employee) {
		return mongoTemplate.remove(employee).getDeletedCount();
	}

	public <T> Long delete(Query query, Class<T> classType) {
		return mongoTemplate.remove(query, classType).getDeletedCount();
	}

	public <T> Long update(Query query, Update update, Class<T> classType) {
		return mongoTemplate.updateFirst(query, update, classType).getModifiedCount();
	}

	public <T> List<T> getDataInList(Query query, Class<T> classType) {
		try {
			return mongoTemplate.find(query, classType);
		} catch (Exception e) {
			LOGGER.error("No Data Found.");
			return null;
		}
	}

	public <T> T getData(Query query, Class<T> classType) {
		try {
			return mongoTemplate.findOne(query, classType);
		} catch (Exception e) {
			LOGGER.error("No Data Found.");
			return null;
		}
	}

	
	
}
