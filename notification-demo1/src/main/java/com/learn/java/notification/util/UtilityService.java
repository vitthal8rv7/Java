package com.learn.java.notification.util;

import com.learn.java.notification.model.DeviceDetailsRO;

public interface UtilityService {

	public void validateDeviceDetails(DeviceDetailsRO deviceDetails);

	public void validateUserId(String userId);

	public void validateApplicationName(String applicationName);

	public void validateAccessToken(String accessToken);

	public void validateNotificationId(String inAppNotificationId, String pushNotificationId);
}
