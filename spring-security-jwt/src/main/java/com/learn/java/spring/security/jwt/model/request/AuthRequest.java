package com.learn.java.spring.security.jwt.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthRequest implements Serializable {

	private static final long serialVersionUID = -7083222110462847114L;
	
	private String username;
	
	private String password;
}
