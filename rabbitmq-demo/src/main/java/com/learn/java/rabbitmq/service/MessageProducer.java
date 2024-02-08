package com.learn.java.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learn.java.rabbitmq.model.User;

@Service
public class MessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${rabbitmq.routing_key}")
	private String routingKey;
	
	@Value("${rabbitmq.json.routing_key}")
	private String jsonRoutingKey;

	@Value("${rabbitmq.json.queue.name}")
	private String queueJsonName;

	public void sendMessageWithQueueName(String message) {
		rabbitTemplate.convertAndSend(queueName, message);
		System.out.println("Message sent: " + message);
	}

	public void sendMessageWithExchangeAndRoutingKey(String message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
		System.out.println("Message sent: " + message);
	}
	
	public void sendJsonMessageWithQueueName(User message) {
		rabbitTemplate.convertAndSend(queueJsonName, message);
		System.out.println("Message sent: " + message);
	}

	public void sendJsonMessageWithExchangeAndRoutingKey(User message) {
		rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, message);
		System.out.println("Message sent: " + message);
	}
}
