package com.learn.java.collection.model;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public Integer sid;
	public String sname;
	
	public Student() {
	}
	
	public Student(Integer id, String name) {
		sid = id;
		sname = name;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
		
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("Inside Equals method.");
//		return super.equals(obj);
//	}
	
//	@Override
//	public String toString() {
//		return "Student [sid=" + sid + ", sname=" + sname + "]";
//	}
	
	@Override  
    protected void finalize()   
    {   
        System.out.println("finalize method called");   
    }  
}
