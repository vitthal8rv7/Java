package com.learn.java.graphql.model;

import java.io.Serializable;
import java.util.List;

public class EmployeeListResponse implements Serializable {

	private static final long serialVersionUID = 3594220378219829642L;

	private List<Employee> employeeList;
	private Pager pager;

	public EmployeeListResponse(List<Employee> content, Pager pager) {
		employeeList = content;
		this.pager = pager;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}
