/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.java.notification.model.InAppNotification;

/**
 * @author Mindstix Software Labs
 *
 */
public interface InAppNotificationsRepository extends MongoRepository<InAppNotification, String> {

	/**
	 * Find by User Id, tenant and IsClear
	 * 
	 * @param userId
	 * @param tenant
	 * @param type
	 * @param isClear
	 *
	 * @return list of InAppNotification
	 */
	List<InAppNotification> findAllByUserIdAndApplicationNameIgnoreCaseAndTypeNotAndIsClearOrderBySentOnDesc(
			String userId, String tenant, String type, Boolean isClear);

	/**
	 * Find by User Id and InAppNotificationId
	 * 
	 * @param userId
	 * @param inAppNotificationId
	 * @return InAppNotificationObject
	 */
	InAppNotification findOneByUserIdAndInAppNotificationId(String userId, String inAppNotificationId);

	/**
	 * Count By User Id, IsRead, IsClear and Tenant
	 * 
	 * 
	 * @param userId
	 * @param isRead
	 * @param isCount
	 * @param tenant
	 * 
	 * @return list of InAppNotificationObject
	 */
	List<InAppNotification> countByUserIdAndIsReadAndIsClearAndApplicationNameIgnoreCase(String userId, Boolean isRead,
			Boolean isCount, String tenant);

	/**
	 * Find By User Id and Push Notification Id
	 * 
	 * @param userId
	 * @param pushNotificationId
	 *
	 * @return InAppNotificationObject
	 */
	InAppNotification findOneByUserIdAndPushNotificationId(String userId, String pushNotificationId);

	List<InAppNotification> findAllByApplicationNameIgnoreCase(String applicationName);

	List<InAppNotification> findAllByUserIdAndApplicationNameIgnoreCase(String userId, String applicationName);

	/**
	 * Find by OwnerId
	 * 
	 * @param userId
	 * @param applicationName
	 * @param type
	 * @param isClear
	 * 
	 * @return List<InAppNotificationObject>
	 */
	List<InAppNotification> findAllByUserIdAndApplicationNameIgnoreCaseAndTypeIgnoreCaseAndIsClearOrderBySentOnDesc(
			String userId, String applicationName, String type, Boolean isClear);

	/**
	 * Count By OwnerId
	 * 
	 * @param userId
	 * @param b
	 * @param c
	 * @param lowerCase
	 *
	 * @return List<InAppNotificationObject>
	 */
	List<InAppNotification> countByOwnerIdAndIsReadAndIsClearAndApplicationNameIgnoreCase(String userId, boolean b,
			boolean c, String lowerCase);

	/**
	 * Find by owner ID
	 * 
	 * @param userId
	 * @param inAppNotificationId
	 *
	 * @return InAppNotificationObject
	 */
	InAppNotification findOneByOwnerIdAndInAppNotificationId(String userId, String inAppNotificationId);

	/**
	 * Find by OwnerId, ApplicationName and IsClear
	 * 
	 * @param userId
	 * @param lowerCase
	 * @param isClear
	 *
	 * @return List<InAppNotificationObject>
	 */
	List<InAppNotification> findAllByOwnerIdAndApplicationNameIgnoreCaseAndIsClearOrderBySentOnDesc(String userId,
			String lowerCase, boolean isClear);

	/**
	 * Find by UserId, ApplicationName and IsClear
	 * 
	 * @param userId
	 * @param lowerCase
	 * @param isClear
	 *
	 * @return List<InAppNotificationObject>
	 */
	List<InAppNotification> findAllByUserIdAndApplicationNameIgnoreCaseAndIsClearOrderBySentOnDesc(String userId,
			String lowerCase, boolean isClear);
}