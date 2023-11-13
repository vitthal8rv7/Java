package com.learn.java.graphql.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -7930719055302146085L;

		private String id;
		
		private String name;
		
		private Double salary;
		
		private Integer age;
		
		private Boolean isManager;

		//private Address address;
		
		public Employee(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public Employee() {
			// TODO Auto-generated constructor stub
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Boolean getIsManager() {
			return isManager;
		}

		public void setIsManager(Boolean isManager) {
			this.isManager = isManager;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", isManager="
					+ isManager + "]";
		}

//		public Address getAddress() {
//			return address;
//		}
//
//		public void setAddress(Address address) {
//			this.address = address;
//		}
//
//		@Override
//		public String toString() {
//			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", isManager="
//					+ isManager + ", address=" + address + "]";
//		}
		
		
}
