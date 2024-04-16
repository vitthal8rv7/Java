package com.learn.java.spring.security.jwt.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = -7474294384342800993L;
	
	private String jwtToken;	
}
