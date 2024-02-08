package com.learn.java.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.learn.java.rabbitmq.config.RabbitmqConstants;

@Component
public class MessageConsumer {

	@RabbitListener(queues = RabbitmqConstants.queueName)
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
