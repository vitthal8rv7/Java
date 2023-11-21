package com.learn.java.notification.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learn.java.notification.config.Constants;
import com.learn.java.notification.config.PropertyHolder;
import com.learn.java.notification.exception.BadRequestException;
import com.learn.java.notification.exception.InternalServerErrorException;
import com.learn.java.notification.model.DeviceDetails;
import com.learn.java.notification.model.DeviceDetailsRO;
import com.learn.java.notification.model.DeviceDetailsVO;
import com.learn.java.notification.repository.DeviceDetailRepository;
import com.learn.java.notification.service.DeviceRegistrationService;
import com.mongodb.client.result.UpdateResult;

@Service
public class DeviceRegistrationServiceImpl implements DeviceRegistrationService {

	@Autowired
	private PropertyHolder propertyHolder;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private DeviceDetailRepository deviceDetailRepository;
	
	@Override
	public Boolean addNewDevice(DeviceDetailsRO deviceDetails, String applicationName, String userId) {
		
		validateDeviceDetails(deviceDetails);
		validateUserId(userId);
		validateApplicationName(applicationName);
		deviceDetails.setUsername(userId);
		deviceDetails.setApplicationName(applicationName);
		try {
			deleteDeviceDetailsByOldToken(deviceDetails);
			DeviceDetails device = deviceDetails.getDeviceDetail();
			device = deviceDetailRepository.save(device);
			return true;
		} catch (Exception e) {
			String internalServerError = "Error occured while saving new device.";
			throw new InternalServerErrorException(internalServerError);
		}
	}

	private void deleteDeviceDetailsByOldToken(DeviceDetailsRO deviceDetails) {
		String deviceTokenNew = deviceDetails.getDeviceTokenNew();
		String deviceTokenOld = deviceDetails.getDeviceTokenOld();
		if (StringUtils.isNotBlank(deviceTokenOld) && !deviceTokenNew.equals(deviceTokenOld)) {
			//deviceDetailRepository.deleteById(deviceTokenOld);
		}		
	}

	private void validateApplicationName(String applicationName) {
		if (StringUtils.isBlank(applicationName)) {
			String badRequest = "Application name should not be empty. Please provide application name.";
			throw new BadRequestException(badRequest);
		}		
	}

	private void validateUserId(String userId) {
		if (StringUtils.isBlank(userId)) {
			String badRequest = "User id should not be empty. Please provide the user id.";
			throw new BadRequestException(badRequest);
		}		
	}

	private void validateDeviceDetails(DeviceDetailsRO deviceDetails) {
		if (Objects.isNull(deviceDetails)) {
			String badRequest = "Device details should not be empty. Please provide the device details.";
			throw new BadRequestException(badRequest);
		}
	}

	@Override
	public Boolean updateLasteActiviteTimestamp(String accessToken, String applicationName) {
		validateAccessToken(accessToken);
//		String maskedAccessToken = MaskingUtility.maskMiddleCharacters(accessToken);
		Query query = new Query();
		query.addCriteria(Criteria.where(Constants.ACCESS_TOKEN_FIELD).is(accessToken));
		Update update = new Update();
		update.set(Constants.LAST_ACTIVE_FIELD, propertyHolder.getCurrentTimeStamp());
		UpdateResult wr = mongoTemplate.updateFirst(query, update, DeviceDetails.class);
		if (wr.wasAcknowledged()) {
			return true;
		} else {
			return false;
		}
	}

	private void validateAccessToken(String accessToken) {
		if (StringUtils.isBlank(accessToken)) {
			String badRequest = "Access token should not be empty. Please provide the access token .";
			throw new BadRequestException(badRequest);
		}		
	}

	@Override
	public List<DeviceDetailsVO> removeDeviceDetailWithAccessToken(String accessToken, String applicationName) {
		validateAccessToken(accessToken);
		Query query = new Query();
		query.addCriteria(Criteria.where(Constants.ACCESS_TOKEN_FIELD).is(accessToken));
		List<DeviceDetails> devices = mongoTemplate.findAllAndRemove(query, DeviceDetails.class);
		if(Objects.isNull(devices) || devices.isEmpty()) {
			return null;
		}
		List<DeviceDetailsVO> devicesVO = new ArrayList<>();
		devices.stream().forEach(device -> {
			devicesVO.add(device.getDeviceDetailsVO());
		});
		return devicesVO;
	}
}
