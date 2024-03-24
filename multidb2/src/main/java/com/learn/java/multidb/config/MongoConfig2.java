package com.learn.java.multidb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig2 {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb2.database}")
    private String database;

    @Bean(name = "mongoClient2")
    public MongoClient mongoClient2() {
    	MongoClient mongoClient = MongoClients.create("mongodb://"+host+":"+port);
        return mongoClient;
    }

    @Bean(name = "mongoTemplate2")
    public MongoTemplate mongoTemplate2() {
        return new MongoTemplate(mongoClient2(), database);
    }
}
