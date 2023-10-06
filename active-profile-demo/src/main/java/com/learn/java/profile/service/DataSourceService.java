package com.learn.java.profile.service;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import com.learn.java.profile.model.MyDataSource;
import com.learn.java.profile.model.MyDataSource2;

@Service
public class DataSourceService {

	@Autowired
	private ConfigurableEnvironment env;

	@Autowired(required=false)
 //   @Profile("prod") // The annotation @Profile is disallowed for this location
    @Qualifier("prodDataSource")
    private MyDataSource prodDataSource;


    @Autowired(required=false)
  //  @Profile("dev") //The annotation @Profile is disallowed for this location
    @Qualifier("devDataSource")
    private MyDataSource devDataSource;


	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String dbUser;

	@Autowired
	private MyDataSource2 myDataSource2;
	
	public String getInfo() {
		String[] envs = env.getActiveProfiles();
		System.out.println("Current Profile (set from properties file at the execution): "+Arrays.asList(envs));
		System.out.println("spring.profiles.active: "+activeProfile);
		System.out.println(" devDataSource is null: "+Objects.isNull(devDataSource) + devDataSource);
		System.out.println("prodDataSource is null: "+Objects.isNull(prodDataSource) + prodDataSource);

		System.out.println("datasourceUrl: "+datasourceUrl);
		System.out.println("dbUser: "+dbUser);

		System.out.println("javaHome: "+prodDataSource.getJavaHome());
		System.out.println("myDataSource2.getName: "+myDataSource2.getName());

		env.setActiveProfiles("dev", "prod");
		envs = env.getActiveProfiles();
		System.out.println("Updated Profile(set from code at runtime): "+Arrays.asList(envs));
		System.out.println("spring.profiles.active: "+activeProfile);		
		System.out.println(" devDataSource is null: "+Objects.isNull(devDataSource) + devDataSource);
		System.out.println("prodDataSource is null: "+Objects.isNull(prodDataSource) + prodDataSource);
		
		System.out.println("datasourceUrl: "+datasourceUrl);
		System.out.println("dbUser: "+dbUser);

		System.out.println("myDataSource2.getName: "+myDataSource2.getName());
		
		return "Active Profile Info Fetched.\n";
	}
}
