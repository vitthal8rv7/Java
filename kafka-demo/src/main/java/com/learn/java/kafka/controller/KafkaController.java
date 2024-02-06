package com.learn.java.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
        System.out.println("Inside produceMessageToCustomTopic: "+message);
        return "Message sent: " + message;
    }

}
