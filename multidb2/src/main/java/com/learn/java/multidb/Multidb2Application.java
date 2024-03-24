package com.learn.java.multidb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = {"com.learn.java.multidb.entity.mysql.db1", "com.learn.java.multidb.entity.mysql.db2"})
public class Multidb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Multidb2Application.class, args);
	}

}
