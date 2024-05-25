package com.learn.java.interview.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

	private static final long serialVersionUID = -5626583605787995466L;
	Integer id;
	
//	@Override
//	public String toString() {
//		return ""+this.hashCode();
//	}
	
	
	
	
}
