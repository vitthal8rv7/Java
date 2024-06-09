package com.learn.java.interview.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee2 implements Serializable {

	private static final long serialVersionUID = 1280001198213810407L;

	Integer id;

	String name;
	
	String visitedCity;

}
