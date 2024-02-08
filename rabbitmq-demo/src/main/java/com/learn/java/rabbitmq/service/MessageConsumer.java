package com.learn.java.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.learn.java.rabbitmq.model.User;

@Service
public class MessageConsumer {

	@RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(String message) {
        System.out.println("Message received: 1 " + message);
    }
	
	@RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage2(String message) {
        System.out.println("Message received: 2 " + message);
    }
	
	@RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage3(String message) {
        System.out.println("Message received: 3 " + message);
    }
	
	@RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void receiveJsonMessage(User message) {
        System.out.println("Message Json received: 1 " + message);
    }

	@RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void receiveJsonMessage2(User message) {
        System.out.println("Message Json received: 2 " + message);
    }

	@RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void receiveJsonMessag3(User message) {
        System.out.println("Message Json received: 3 " + message);
    }

}
