package com.learn.java.kafka.controller;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.kafka.model.Farewell;
import com.learn.java.kafka.model.Greeting;
import com.learn.java.kafka.model.User;

@RestController
@RequestMapping("/kafka/demo")
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Object> genericKafkaTemplate;

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

	@PostMapping("/produce/new-message-to-new-topic3")
	public String produceMessageToNewTopic3(@RequestBody String message) {
		kafkaTemplate.send("newTopic3", message);
		return "Message sent::: " + message;
	}

	@PostMapping("/produce/new-message-to-new-topic4")
	public String produceMessageToNewTopic4(@RequestBody String message) {
		kafkaTemplate.send("newTopic4", message);
		return "Message sent:::: " + message;
	}

	@PostMapping("/produce/new-message-to-new-topic5")
	public String produceMessageToNewTopic5(@RequestBody Greeting greetingMessage) {
		System.out.println("Inside Producer");
		greetingKafkaTemplate.send("newTopic5", greetingMessage);
		return "Message sent:::: " + greetingMessage;
	}

	@PostMapping("/produce/new-message-to-new-topic6")
	public String produceMessageToNewTopic6(@RequestBody String message) {
		System.out.println("Inside Producer");
		ProducerRecord<String,Object> p = new ProducerRecord<>("newTopic6", new Greeting("g1","g2"));
		genericKafkaTemplate.send(p);

		ProducerRecord<String,Object> p2 = new ProducerRecord<>("newTopic6", new Farewell("f1","f2"));
		genericKafkaTemplate.send(p2);

		ProducerRecord<String,Object> p3 = new ProducerRecord<>("newTopic6", "Default String");
		genericKafkaTemplate.send(p3);

		
		return "Message sent:::: " + message;
	}

	
	
}
