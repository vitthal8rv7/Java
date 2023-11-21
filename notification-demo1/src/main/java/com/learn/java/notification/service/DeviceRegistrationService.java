package com.learn.java.notification.service;

import java.util.List;

import com.learn.java.notification.model.DeviceDetailsRO;
import com.learn.java.notification.model.DeviceDetailsVO;

public interface DeviceRegistrationService {

	Boolean addNewDevice(DeviceDetailsRO deviceDetail, String applicationName, String userId);

	Boolean updateLasteActiviteTimestamp(String accessToken, String applicationName);

	List<DeviceDetailsVO> removeDeviceDetailWithAccessToken(String accessToken, String applicationName);

}
