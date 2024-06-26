package com.learn.java.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.host}")
	private String hostname;

	@Value("${spring.rabbitmq.port}")
	private int port;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	@Value("${rabbitmq.routing_key}")
	private String routingKey;

	@Value("${rabbitmq.json.queue.name}")
	private String queueJsonName;

	@Value("${rabbitmq.json.routing_key}")
	private String jsonRoutingKey;

	@Bean
	Queue myQueue() {
		return new Queue(queueName, true); // Declare a durable queue
	}

//	@Bean
//	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//		return new RabbitAdmin(connectionFactory);
//	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(myQueue()).to(exchange()).with(routingKey);
	}

	@Bean
	Queue myJsonQueue() {
		return new Queue(queueJsonName, true); // Declare a durable queue
	}

	@Bean
	Binding jsonBinding() {
		return BindingBuilder.bind(myJsonQueue()).to(exchange()).with(jsonRoutingKey);
	}

	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

//	@Bean
//	Binding binding(Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with("rounting_key_1");
//	}

//	@Bean
//	ConnectionFactory connectionFactory() {
//		final CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname, port);
//		connectionFactory.setUsername(username);
//		connectionFactory.setPassword(password);
//		return connectionFactory;
//	}

}