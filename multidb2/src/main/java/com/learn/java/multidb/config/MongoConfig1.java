package com.learn.java.multidb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig1 {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb1.database}")
    private String database;

    @Bean(name = "mongoClient1")
    public MongoClient mongoClient1() {
    	MongoClient mongoClient = MongoClients.create("mongodb://"+host+":"+port);
        return mongoClient;
    }

    @Bean(name = "mongoTemplate1")
    public MongoTemplate mongoTemplate1() {
        return new MongoTemplate(mongoClient1(), database);
    }
}
