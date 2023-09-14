package com.learn.java.collection.mpdel;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public Integer sid;
	public String sname;
	
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
	
    @Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	@Override  
    protected void finalize()   
    {   
        System.out.println("finalize method called");   
    }  
}
