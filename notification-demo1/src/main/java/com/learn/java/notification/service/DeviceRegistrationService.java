package com.learn.java.notification.service;

import java.util.List;

import com.learn.java.notification.model.DeviceDetailsRO;
import com.learn.java.notification.model.DeviceDetailsVO;

public interface DeviceRegistrationService {

	public Boolean addNewDevice(DeviceDetailsRO deviceDetail, String applicationName, String userId);

	public Boolean updateLasteActiviteTimestamp(String accessToken, String applicationName);

	public List<DeviceDetailsVO> removeDeviceDetailWithAccessToken(String accessToken, String applicationName);

}
