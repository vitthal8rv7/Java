/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.learn.java.notification.model.DeviceDetails;

/**
 * @author Mindstix
 *
 */
public interface DeviceDetailRepository extends MongoRepository<DeviceDetails, String> {

	/**
	 * Find all devices to nudge
	 * 
	 * @param lastNudgeLimit
	 * @param lastActiveLimit
	 * @return list of DeviceDetail
	 */
	@Query("{ '$and': [ { 'lastNudge': { $lt: ?0 } }, {'lastActive': { $lt: ?1 }} ] }")
	public List<DeviceDetails> findAllDeviceToNudge(Long lastNudgeLimit, Long lastActiveLimit);

	/**
	 * Find all devices from market ids
	 * 
	 * @param markets
	 * @return list of DeviceDetail
	 */
	@Query("{ 'markets' : { $elemMatch :{'marketId' : {$in: ?0 }}}}")
	public List<DeviceDetails> findAllDevicesFromMarketIds(String[] markets);

	/**
	 * Find all by usernames
	 * 
	 * @param username
	 * @return list of DeviceDetail
	 */
	@Query("{'username' : {$in: ?0 }}")
	public List<DeviceDetails> findAllByUsernames(String[] username);

	/**
	 * Find all by tenants
	 * 
	 * @param tenant
	 * @return list of DeviceDetail
	 */
	public List<DeviceDetails> findAllByApplicationNameIgnoreCase(String tenant);
}