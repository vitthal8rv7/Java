package com.learn.java.notification.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.java.notification.model.DeviceDetails;
import com.learn.java.notification.model.DeviceDetailsRO;
import com.learn.java.notification.service.DeviceRegistrationService;

@Service
public class DeviceRegistrationServiceImpl implements DeviceRegistrationService {

	@Override
	public Boolean addNewDevice(DeviceDetailsRO deviceDetail, String applicationName, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateLasteActiviteTimestamp(String accessToken, String applicationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeviceDetails> removeDeviceDetailWithAccessToken(String accessToken, String applicationName) {
		// TODO Auto-generated method stub
		return null;
	}

}
