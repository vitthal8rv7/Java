package com.learn.java.interview.model.test;

public class Student {
	private Integer id;
	private String fname;
	private Double cgpa;
	public Student(Integer id, String fname, Double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public Integer getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public Double getCgpa() {
		return cgpa;
	}
}
