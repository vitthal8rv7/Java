package com.learn.java.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
