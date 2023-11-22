package com.learn.java.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.notification.model.Notification;
import com.learn.java.notification.model.NotificationRO;
import com.learn.java.notification.service.NotificationService;

@RestController
@RequestMapping("/push/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping(value = "/push/notifications")
	public Boolean pushNotifications(@RequestBody(required = false) NotificationRO pushNotification,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId) {	
		Notification notification = pushNotification.getNotification();
		return notificationService.pushNotificationsForUsersWithTitleAndBody(pushNotification.getUsers(), notification,
				pushNotification.getContentType());
	}

}
