package com.learn.java.mysql.util;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.learn.java.mysql.model.dto.EmployeeDto;
import com.learn.java.mysql.model.entity.Employee;

public class EmployeeUtil {

	public static EmployeeDto getEmployee(Employee employee) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(employee, EmployeeDto.class);
	}

	public static List<EmployeeDto> convertEmployeeListToEmployeeDtoList(List<Employee> employees) {
		ModelMapper modelMapper = new ModelMapper();
		return Arrays.asList(modelMapper.map(employees, EmployeeDto[].class));
	}

	public static List<Employee> convertEmployeeDtoListToEmployeeList(List<EmployeeDto> employees) {
		ModelMapper modelMapper = new ModelMapper();
		return Arrays.asList(modelMapper.map(employees, Employee[].class));
	}

}
