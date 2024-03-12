package com.learn.java.mysql.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

import io.micrometer.common.util.StringUtils;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// Logic
		// If authenticated and authorized 
		// return createdBy/ModifiedBy
		String authentication = "userName/email";
		if(StringUtils.isNotBlank(authentication))
		{
			return Optional.ofNullable("user1");
		} else {
			//else
			return Optional.empty();	
		}			
	}
}
