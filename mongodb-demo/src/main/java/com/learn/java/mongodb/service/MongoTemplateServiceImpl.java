package com.learn.java.mongodb.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.learn.java.mongodb.collection.Employee;
import com.learn.java.mongodb.repository.EmployeeRepository;

@Service
public class MongoTemplateServiceImpl implements MongoTemplateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoTemplateServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setDateOfJoining(new Date(System.currentTimeMillis()));
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getEmployeeAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(String id, String name) {
		Employee employee = employeeRepository.findById(id);
		if (Objects.isNull(employee)) {
			LOGGER.info("Employee not found.");
			return null;
		} else {
			employee.setName(name);
			return employeeRepository.save(employee);
		}
	}

	@Override
	public String deleteEmployee(String id) {
		Employee employee = employeeRepository.findById(id);
		if (Objects.isNull(employee)) {
			return "Employee not found.";
		} else {
			return employeeRepository.deleteById(employee) + " Employee Deleted Successfully";
		}
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(Float minSalary, Float maxSalary) {
		Query query = new Query(Criteria.where("salary").gte(minSalary).and("salary").lt(maxSalary));
		 return employeeRepository.getDataInList(query, Employee.class);
	}

	@Override
	public List<Employee> getEmployeeBySalary(Float salary) {
		Query query = new Query(Criteria.where("salary").gte(salary));
		return employeeRepository.getDataInList(query, Employee.class);
	}

	@Override
	public void testCriteriaWithMongoTemplate() {
		Query query = null;
		
		// Regex
		query = new Query(Criteria.where("name").regex("^g"));
		LOGGER.info("[Regex] : Employee list whose name starts with g : " + employeeRepository.getDataInList(query, Employee.class)); 
		
		
	}
}
