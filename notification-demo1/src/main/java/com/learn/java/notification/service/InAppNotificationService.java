package com.learn.java.notification.service;

import java.util.List;

import com.learn.java.notification.model.CountVO;
import com.learn.java.notification.model.InAppNotificationVO;

public interface InAppNotificationService {

	List<InAppNotificationVO> fetchInAppNotifications(String applicationName, String userId, Boolean calendar);

	List<InAppNotificationVO> clearInAppNotification(String inAppNotificationId, String pushNotificationId,
			String applicationName, String userId, Boolean calendar);

	Boolean clearAllInAppNotificationsForUser(String applicationName, String userId, Boolean calendar);

	Boolean readInAppNotification(String inAppNotificationId, String pushNotificationId, String userId,
			Boolean calendar, String applicationName);

	CountVO countInAppNotification(String applicationName, String userId, Boolean calendar);

}
