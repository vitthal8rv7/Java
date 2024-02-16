package com.learn.java.mongodb.collection;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {

	private static final long serialVersionUID = 8657014830755038405L;

	private String address1;
	private String address2;
	private String city;
}
