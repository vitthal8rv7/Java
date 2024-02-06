package com.learn.java.kafka.config;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.java.kafka.model.User;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void listen(String message) {

//    	ModelMapper modelMapper = new ModelMapper();
//		User userObject = modelMapper.map(message, User.class);
//		System.out.println("Received message: userObject: " + userObject);
	
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			User userObj = mapper.readValue(message, User.class);
			System.out.println("Received message: userObj: " + userObj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Received message: " + message);
    }
    
    @KafkaListener(topics = "myTopic123", groupId = "test-group")
    public void listenToMyTopic(String message) {
        System.out.println("Received message: " + message);
    }
}
