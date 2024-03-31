package com.learn.java.security.model.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("user")
public class User implements Serializable {

	private static final long serialVersionUID = -1684162374362720259L;

	@Id
	private String id;
	
	private String userName;
	
	private String password;
	
	private String salt;
	
	private List<String> roles;
	
	private List<String> authorities;
	
}
