package com.learn.java.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.learn.java.rabbitmq.config.RabbitmqConstants;

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
}
