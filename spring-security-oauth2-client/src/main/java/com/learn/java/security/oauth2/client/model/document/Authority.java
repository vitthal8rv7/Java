package com.learn.java.security.oauth2.client.model.document;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = -7083414489843523026L;
	
	public String authority;
	
	@Override
	public String getAuthority() {
		return authority;
	}


}
