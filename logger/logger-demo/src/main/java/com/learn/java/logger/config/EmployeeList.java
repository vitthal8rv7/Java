package com.learn.java.logger.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.learn.java.logger.model.Employee;

@Component
public class EmployeeList {

	@Bean
	List<Employee> getEmployees() {
		return getEmployeeList();
	}
	
	private List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("id1", "ename1"));
		employeeList.add(new Employee("id2", "ename2"));
		employeeList.add(new Employee("id3", "ename3"));
		employeeList.add(new Employee("id4", "ename4"));
		employeeList.add(new Employee("id5", "ename5"));
		employeeList.add(new Employee("id6", "ename6"));
		employeeList.add(new Employee("id7", "ename7"));
		employeeList.add(new Employee("id8", "ename8"));
		employeeList.add(new Employee("id9", "ename9"));
		employeeList.add(new Employee("id10", "ename10"));
		employeeList.add(new Employee("id11", "ename11"));
		employeeList.add(new Employee("id12", "ename12"));
		employeeList.add(new Employee("id13", "ename13"));
		employeeList.add(new Employee("id14", "ename14"));
		return employeeList;
	}

	
}
