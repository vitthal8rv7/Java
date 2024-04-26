package com.learn.java.security.oauth2.client.model.response;

import java.io.Serializable;
import java.util.Set;

import com.learn.java.security.oauth2.client.model.document.Authority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Oauth2UserInfoDto implements Serializable {
	
	private static final long serialVersionUID = 4189652931788624926L;
	
	private String id;

	private Set<Authority> authorities;

	private String name;

	private String picture;

	private String username;

	private String email;
}
