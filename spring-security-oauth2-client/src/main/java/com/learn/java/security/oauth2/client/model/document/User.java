package com.learn.java.security.oauth2.client.model.document;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "OAuthUser")
public class User implements UserDetails {

	private static final long serialVersionUID = 3086020480127516029L;

	@Id
	private String id;

	private Set<Authority> authorities;

	private String password;

	private String name;

	private String picture;

	private String email;
	
	private String username;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private String provider;

	private String providerId;

	private boolean enabled;
}
