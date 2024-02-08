package com.learn.java.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.rabbitmq.model.User;
import com.learn.java.rabbitmq.service.MessageProducer;

@RestController
@RequestMapping("/rabbitmq/demo")
public class RabbitmqController {

    @Autowired
    private MessageProducer messageProducer;

	@PostMapping("/produce")
	public String produceMessage(@RequestBody String message) {
		messageProducer.sendMessageWithQueueName(message);
		messageProducer.sendMessageWithExchangeAndRoutingKey(message);
		return "Message sent: " + message;
	}
	
	@PostMapping("/produce/user")
	public String produceMessage(@RequestBody User message) {
		messageProducer.sendJsonMessageWithQueueName(message);
		messageProducer.sendJsonMessageWithExchangeAndRoutingKey(message);
		return "Message sent: " + message;
	}

}
