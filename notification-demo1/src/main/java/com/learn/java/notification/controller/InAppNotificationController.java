package com.learn.java.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.notification.model.CountVO;
import com.learn.java.notification.model.InAppNotificationVO;
import com.learn.java.notification.service.InAppNotificationService;

@RestController
@RequestMapping("/in-app/notification")
public class InAppNotificationController {

	@Autowired
	private InAppNotificationService inAppNotificationService;

	@GetMapping(value = "/fetch")
	public List<InAppNotificationVO> getInAppNotification(@RequestHeader(required = false) String applicationName,
			@RequestHeader(required = false) String userId, @RequestParam(required = false) Boolean calendar) {
		return inAppNotificationService.fetchInAppNotifications(applicationName, userId, calendar);
	}

	@GetMapping(value = "/clear")
	public List<InAppNotificationVO> clearInAppNotification(@RequestParam(required = false) String inAppNotificationId,
			@RequestParam(required = false) String pushNotificationId,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId,
			@RequestParam(required = false) Boolean calendar) {
		return inAppNotificationService.clearInAppNotification(inAppNotificationId, pushNotificationId,
				applicationName, userId, calendar);
	}

	@GetMapping(value = "/clear/all")
	public Boolean clearAllInAppNotification(@RequestHeader(required = false) String applicationName,
			@RequestHeader(required = false) String userId, @RequestParam(required = false) Boolean calendar) {
		return inAppNotificationService.clearAllInAppNotificationsForUser(applicationName, userId, calendar);
	}

	@GetMapping(value = "/read")
	public Boolean readInAppNotification(@RequestParam(required = true) String inAppNotificationId,
			@RequestParam(required = false) String pushNotificationId,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId,
			@RequestParam(required = false) Boolean calendar) {
		return inAppNotificationService.readInAppNotification(inAppNotificationId, pushNotificationId, userId, calendar,
				applicationName);
	}

	@GetMapping(value = "/count")
	public CountVO countInAppNotification(@RequestHeader(required = false) String applicationName,
			@RequestHeader(required = false) String userId, @RequestParam(required = false) Boolean calendar) {
		return inAppNotificationService.countInAppNotification(applicationName, userId, calendar);
	}

}
