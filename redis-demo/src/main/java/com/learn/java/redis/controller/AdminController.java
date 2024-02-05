package com.learn.java.redis.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.redis.cache.CacheConstants;

@RestController
@RequestMapping("/redis/demo/admin")
public class AdminController {
	
//	@Autowired
//	private CompanyService companyService;
	
	@Cacheable(value = "getCompanyName", keyGenerator = CacheConstants.COMMON_TO_ALL_KEY_GENERATOR)
	@GetMapping("/company/name")
	String getCompanyName() {
		System.out.println("In Get Admin Controller.");
		return "ABC_Z Company";
		//return companyService.getCompanyName();
	}


}
