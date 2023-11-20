package com.learn.java.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.notification.config.PropertyHolder;
import com.learn.java.notification.model.DeviceDetails;
import com.learn.java.notification.model.DeviceDetailsRO;
import com.learn.java.notification.service.DeviceRegistrationService;

@RestController
@RequestMapping("/device/registration")
public class DeviceRegistrationController {

	@Autowired
	private PropertyHolder propertyHolder;

	@Autowired
	private DeviceRegistrationService deviceRegistrationService;

	@PostMapping(value = "/device/register")
	public Boolean registerDevice(@RequestBody DeviceDetailsRO deviceDetail,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId) {
		// deviceDetail.setLastActive(propertyHolder.getCurrentTimeStamp());
		// deviceDetail.setLastNudge(propertyHolder.getCurrentTimeStamp());
		return deviceRegistrationService.addNewDevice(deviceDetail, applicationName.toLowerCase(), userId);
	}

	@GetMapping(value = "/device/update/lastactive")
	public Boolean updateUserLastActivity(@RequestParam String accessToken,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId) {
		return deviceRegistrationService.updateLasteActiviteTimestamp(accessToken, applicationName);
	}

	@GetMapping(value = "/device/remove")
	public List<DeviceDetails> removeDeviceDetailWithAccessToken(@RequestParam String accessToken,
			@RequestHeader(required = false) String applicationName, @RequestHeader(required = false) String userId) {
		return deviceRegistrationService.removeDeviceDetailWithAccessToken(accessToken, applicationName);
	}

}
