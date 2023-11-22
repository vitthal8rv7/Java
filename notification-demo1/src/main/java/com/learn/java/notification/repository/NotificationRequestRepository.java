package com.learn.java.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.java.notification.model.NotificationRequest;

public interface NotificationRequestRepository extends MongoRepository<NotificationRequest, String> {

}