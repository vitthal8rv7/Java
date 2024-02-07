package com.learn.java.kafka.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.kafka.model.User;

@RestController
@RequestMapping("/kafka/demo")
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/produce")
	public String produceMessage(@RequestBody String message) {
		kafkaTemplate.send("test-topic", message);
		return "Message sent: " + message;
	}

	@PostMapping("/produce/user")
	public String produceMessage(@RequestBody User user) {
		kafkaTemplate.send("test-topic", user.toString());
		return "Message sent: " + user;
	}

	@PostMapping("/produce/programatically-created-topic")
	public String produceMessageToCustomTopic(@RequestBody String message) {
		kafkaTemplate.send("myTopic123", message);
		System.out.println("Inside produceMessageToCustomTopic: " + message);
		return "Message sent: " + message;
	}

	@PostMapping("/produce/new-message")
	public String produceNewMessage(@RequestBody String message) {
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("test-topic", message);
		future.whenComplete((result, exception) -> {
			if (exception == null) {
				System.out.println(
						"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to : " + exception.getMessage());
			}
		});
		return "Message sent: " + message;
	}

	@PostMapping("/produce/new-message-to-new-topic1")
	public String produceMessageToNewTopic1(@RequestBody String message) {
		kafkaTemplate.send("newTopic1", message);
		return "Message sent: " + message;
	}

	@PostMapping("/produce/new-message-to-new-topic2")
	public String produceMessageToNewTopic2(@RequestBody String message) {
		kafkaTemplate.send("newTopic2", message);
		return "Message sent: " + message;
	}

}
