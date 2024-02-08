package com.learn.java.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learn.java.rabbitmq.config.RabbitmqConstants;

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

	public void sendMessageWithQueueName(String message) {
		rabbitTemplate.convertAndSend(queueName, message);
		System.out.println("Message sent: " + message);
	}

	public void sendMessageWithExchangeAndRoutingKey(String message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
		System.out.println("Message sent: " + message);
	}
}
