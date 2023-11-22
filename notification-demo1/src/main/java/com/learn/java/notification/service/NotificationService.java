package com.learn.java.notification.service;

import java.util.List;

import com.learn.java.notification.model.Notification;
import com.learn.java.notification.model.UserDetail;

public interface NotificationService {

	public default Boolean pushNotificationsForUsersWithTitleAndBody(List<UserDetail> users, Notification notification,
			String contentType) {
		return false;
	}

}
