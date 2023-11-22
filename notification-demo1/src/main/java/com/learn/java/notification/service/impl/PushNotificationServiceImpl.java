package com.learn.java.notification.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.learn.java.notification.config.Constants;
import com.learn.java.notification.config.PropertyHolder;
import com.learn.java.notification.model.DeviceDetails;
import com.learn.java.notification.model.InAppNotification;
import com.learn.java.notification.model.Notification;
import com.learn.java.notification.model.NotificationRequest;
import com.learn.java.notification.model.UserDetail;
import com.learn.java.notification.repository.DeviceDetailRepository;
import com.learn.java.notification.repository.InAppNotificationsRepository;
import com.learn.java.notification.repository.NotificationRequestRepository;
import com.learn.java.notification.service.NotificationService;
import com.learn.java.notification.service.RestApiService;
import com.learn.java.notification.util.UtilityService;

@Primary
@Service
public class PushNotificationServiceImpl implements NotificationService {

	@Autowired
	private DeviceDetailRepository deviceDetailRepository;

	@Autowired
	private UtilityService utilityService;

	@Autowired
	private NotificationRequestRepository notificationRequestRepository;

	@Autowired
	private InAppNotificationsRepository inAppNotificationsRepository;

	@Autowired
	private PropertyHolder propertyHolder;

	@Autowired
	private RestApiService restApiService;

	@Override
	public Boolean pushNotificationsForUsersWithTitleAndBody(List<UserDetail> users, Notification notification,
			String contentType) {
		List<String> userIds = users.stream().map(UserDetail::getWorkEmailAddress).collect(Collectors.toList());
		List<DeviceDetails> devices = deviceDetailRepository.findAllByUsernames(userIds.toArray(new String[0]));
		if (CollectionUtils.isNotEmpty(devices)) {
			List<String> deviceTokensToSendNotification = devices.stream().map(DeviceDetails::getDeviceTokenNew)
					.collect(Collectors.toList());
			notification.setImageId(utilityService.getImageId(notification.getImageId()));
			notification.setCommentId(utilityService.getCommentId(notification.getCommentId()));
			Long currentTimeInMillies = System.currentTimeMillis();
			NotificationRequest notificationRequest = saveDevices(notification, deviceTokensToSendNotification, devices,
					currentTimeInMillies);
			List<InAppNotification> newInAppNotifications = getNewInAppNotifications(users, notificationRequest,
					notification, contentType, currentTimeInMillies);
			inAppNotificationsRepository.saveAll(newInAppNotifications);
			// LOGGER.debug(logHelper.getAPIRequestLog(Boolean.FALSE,
			// notification.getApplicationName()),
			// "{} in-app-notifications saved.", newInAppNotifications.size(),
			// notification.getApplicationName());
			pushNotificationOnDevices(notificationRequest, notification.getApplicationName());
		} else {
			// LOGGER.debug(logHelper.getAPIRequestLog(Boolean.FALSE,
			// notification.getApplicationName()),
			// "No device is registed yet.", notification.getApplicationName());
		}
		return true;
	}

	private List<InAppNotification> getNewInAppNotifications(List<UserDetail> users,
			NotificationRequest notificationRequest, Notification notification, String contentType,
			Long currentTimeInMillies) {
		List<InAppNotification> newInAppNotifications = new ArrayList<>();
		for (UserDetail user : users) {
			InAppNotification inAppNotification;
			inAppNotification = newInAppNotifications.stream()
					.filter(x -> (notificationRequest.getNotification().getNotificationId()
							.equals(x.getPushNotificationId()) && user.getId().equals(x.getUserId())))
					.findAny().orElse(null);
			if (Objects.isNull(inAppNotification)) {
				inAppNotification = InAppNotification.getInAppNotification(notificationRequest, notification,
						contentType, user, currentTimeInMillies);
				inAppNotification.setCommentId(
						utilityService.getNotificationCommentId(notification.getCommentId(), user.getCommentId()));
				newInAppNotifications.add(inAppNotification);
			}
		}
		return newInAppNotifications;
	}

	public synchronized void pushNotificationOnDevices(NotificationRequest notificationRequest,
			String applicationName) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(Constants.AUTHORIZATION,
				Constants.KEY + Constants.EQUALSTO + propertyHolder.getFirebaseServerKey());
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (notificationRequest.getRegistrationIds().isEmpty()) {
			// LOGGER.warn(logHelper.getAPIRequestLog(Boolean.FALSE, applicationName),
			// "There are no devices to push notification", applicationName);
		} else {
			restApiService.postForObject(propertyHolder.getFcmEndpoint(), headers, notificationRequest, String.class);
			// LOGGER.info(logHelper.getAPIRequestLog(Boolean.FALSE, applicationName),
			// "Notification sent on devices, notificationId : {}",
			// notificationRequest.getId(), applicationName);
		}
	}

	private NotificationRequest saveDevices(Notification notification, List<String> deviceTokensToSendNotification,
			List<DeviceDetails> devices, Long currentTimeInMillies) {
		NotificationRequest notificationRequest = notification.getNotificationRequest(notification,
				deviceTokensToSendNotification, currentTimeInMillies);
		notificationRequest = notificationRequestRepository.save(notificationRequest);
		String notificationId = notificationRequest.getId();
		notification.setNotificationId(notificationId);
		notificationRequest.setData(notification);

		devices.parallelStream().forEach(device -> {
			List<String> notificationsSent = device.getNotificationIds();
			notificationsSent.add(notificationId);
			device.setNotificationIds(notificationsSent);
		});
		deviceDetailRepository.saveAll(devices);

		return notificationRequest;
	}

}
