package com.learn.java.notification.util;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.learn.java.notification.exception.BadRequestException;
import com.learn.java.notification.model.DeviceDetailsRO;

@Service
public class UtilityServiceImpl implements UtilityService {

	@Override
	public void validateApplicationName(String applicationName) {
		if (StringUtils.isBlank(applicationName)) {
			String badRequest = "Application name should not be empty. Please provide application name.";
			throw new BadRequestException(badRequest);
		}
	}

	@Override
	public void validateUserId(String userId) {
		if (StringUtils.isBlank(userId)) {
			String badRequest = "User id should not be empty. Please provide the user id.";
			throw new BadRequestException(badRequest);
		}
	}

	@Override
	public void validateDeviceDetails(DeviceDetailsRO deviceDetails) {
		if (Objects.isNull(deviceDetails)) {
			String badRequest = "Device details should not be empty. Please provide the device details.";
			throw new BadRequestException(badRequest);
		}
	}

	@Override
	public void validateAccessToken(String accessToken) {
		if (StringUtils.isBlank(accessToken)) {
			String badRequest = "Access token should not be empty. Please provide the access token .";
			throw new BadRequestException(badRequest);
		}
	}

	@Override
	public void validateNotificationId(String inAppNotificationId, String pushNotificationId) {
		if ((StringUtils.isBlank(inAppNotificationId)) && (StringUtils.isBlank(pushNotificationId))) {
			String emptyNotificationId = "inAppNotificationId and pushNotificationId both should not be empty. Please provide any both or any 1 of them.";
			throw new BadRequestException(emptyNotificationId);
		}
	}
	
	@Override
	public String getCommentId(String commentId) {
		return StringUtils.isBlank(commentId) ? ("") : (commentId);

	}

	@Override
	public String getImageId(String imageId) {
		return StringUtils.isBlank(imageId) ? ("") : (imageId);
	}
	
	@Override
	public  String getNotificationCommentId(String notificationCommentId, String userCommentId) {
		String commentId = notificationCommentId;
		if ((StringUtils.isBlank(notificationCommentId)) && (StringUtils.isNotBlank(userCommentId))) {
			commentId = userCommentId;
		}
		return commentId;
	}


}
