package com.learn.java.mysql.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@Embeddable
public class Name implements Serializable {

	private static final long serialVersionUID = -8949466076192707257L;

	private String firstName;
	
	private String lastName;

}