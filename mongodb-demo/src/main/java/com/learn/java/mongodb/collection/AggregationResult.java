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
public class AggregationResult implements Serializable {

	private static final long serialVersionUID = 8657014830755038405L;

	private String _id;
	private Float totalSalary;
	private Float averageSalary;
	private String length;
}
