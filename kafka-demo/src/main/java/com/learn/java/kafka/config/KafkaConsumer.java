package com.learn.java.kafka.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
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

	@KafkaListener(topics = { "newTopic1", "newTopic2" }, groupId = "test-group")
	public void listenToMultipleTopics(String message) {
		System.out.println("Received message:: " + message);
	}

	@KafkaListener(topics = "newTopic3")
	public void listenWithHeaders(@Payload String message, @Header(name = "number") int partition) {
		System.out.println("Received Message::: " + message + "from partition: " + partition);
	}

	@KafkaListener(topics = "newTopic4", containerFactory = "filterKafkaListenerContainerFactory")
	public void listenWithFilter(String message) {
		System.out.println("Received Message in filtered listener: " + message);
	}

}
