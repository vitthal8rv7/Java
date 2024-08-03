package com.learn.java.graphql.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -7930719055302146085L;

		private String id;		
		private String name;
}
