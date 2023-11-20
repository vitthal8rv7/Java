package com.learn.java.notification.service;

import java.util.List;

import com.learn.java.notification.model.DeviceDetails;
import com.learn.java.notification.model.DeviceDetailsRO;

public interface DeviceRegistrationService {

	Boolean addNewDevice(DeviceDetailsRO deviceDetail, String applicationName, String userId);

	Boolean updateLasteActiviteTimestamp(String accessToken, String applicationName);

	List<DeviceDetails> removeDeviceDetailWithAccessToken(String accessToken, String applicationName);

}
