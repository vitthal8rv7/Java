package com.learn.java.notification.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.learn.java.notification.config.Constants;
import com.learn.java.notification.exception.DataNotFoundException;
import com.learn.java.notification.exception.InternalServerErrorException;
import com.learn.java.notification.model.CountVO;
import com.learn.java.notification.model.InAppNotification;
import com.learn.java.notification.model.InAppNotificationVO;
import com.learn.java.notification.repository.InAppNotificationsRepository;
import com.learn.java.notification.service.InAppNotificationService;
import com.learn.java.notification.util.UtilityService;

@Service
public class InAppNotificationServiceImpl implements InAppNotificationService {

	@Autowired
	private UtilityService utilityService;

	@Autowired
	private InAppNotificationsRepository inAppNotificationsRepository;

	@Override
	public List<InAppNotificationVO> fetchInAppNotifications(String applicationName, String userId, Boolean calendar) {
		utilityService.validateUserId(userId);
		utilityService.validateApplicationName(applicationName);
		List<InAppNotificationVO> notifications = getNotifications(userId, applicationName, calendar);
		if (CollectionUtils.isEmpty(notifications)) {
			throw new DataNotFoundException(Constants.NO_IN_APP_NOTIFICATION_FOUND_WITH_USER_ID);
		} else {
			notifications.stream().forEach(notification -> {
				notification.setType((StringUtils.isEmpty(notification.getType())) ? ("") : (notification.getType()));
				notification.setId((StringUtils.isEmpty(notification.getId())) ? ("") : (notification.getId()));
			});
		}
		return notifications;
	}

	private List<InAppNotificationVO> getNotifications(String userId, String applicationName, Boolean calendar) {
		List<InAppNotification> notifications = (Boolean.TRUE.equals(calendar))
				? (inAppNotificationsRepository.findAllByOwnerIdAndApplicationNameIgnoreCaseAndIsClearOrderBySentOnDesc(
						userId, applicationName.toLowerCase(), false))
				: (inAppNotificationsRepository
						.findAllByUserIdAndApplicationNameIgnoreCaseAndTypeNotAndIsClearOrderBySentOnDesc(userId,
								applicationName.toLowerCase(), Constants.ADMIN_CALENDAR, false));
		List<InAppNotificationVO> notificationVOs = new ArrayList<>();
		notifications.stream().forEach(notification -> {
			notificationVOs.add(notification.getNotificationVO());
		});
		return notificationVOs;
	}

	@Override
	public List<InAppNotificationVO> clearInAppNotification(String inAppNotificationId, String pushNotificationId,
			String applicationName, String userId, Boolean calendar) {
		utilityService.validateNotificationId(inAppNotificationId, pushNotificationId);
		List<InAppNotificationVO> inAppNotificationVOs = fetchInAppNotifications(applicationName, userId, calendar);
		InAppNotificationVO notificationToClear = null;
		notificationToClear = getNotificationToClear(inAppNotificationVOs, inAppNotificationId, pushNotificationId);
		if (!Objects.isNull(notificationToClear)) {
			inAppNotificationVOs.remove(notificationToClear);
			notificationToClear.setIsClear(true);
			inAppNotificationsRepository.save(notificationToClear.getInAppNotification());
			return inAppNotificationVOs;
		} else {
			throw new DataNotFoundException(Constants.NO_IN_APP_NOTIFICATION_FOUND_WITH_IN_APP_OR_PUSH_NOTIFICATION_ID);
		}
	}

	private InAppNotificationVO getNotificationToClear(List<InAppNotificationVO> inAppNotificationVOs,
			String inAppNotificationId, String pushNotificationId) {
		InAppNotificationVO inAppNotificationVO = inAppNotificationVOs.stream()
				.filter(notification -> notification.getNotificationId().equalsIgnoreCase(inAppNotificationId))
				.findAny().orElse(null);
		return inAppNotificationVO;
	}

	@Override
	public Boolean clearAllInAppNotificationsForUser(String applicationName, String userId, Boolean calendar) {
		try {
			List<InAppNotificationVO> inAppNotificationVOs = fetchInAppNotifications(applicationName, userId, calendar);
			inAppNotificationVOs.stream().forEach(notification -> notification.setIsClear(true));
			List<InAppNotification> inAppNotifications = new ArrayList<>();
			inAppNotificationVOs.stream()
					.forEach(notification -> inAppNotifications.add(notification.getInAppNotification()));
			saveAllInAppNotifications(inAppNotifications);
			return true;
		} catch (Exception e) {
			String exception = "Error occured while clearing all the notifications for user.";
			throw new InternalServerErrorException(exception);
		}
	}

	private void saveAllInAppNotifications(List<InAppNotification> notificationObjects) {
		Integer fromIndex = 0;
		Integer toIndex = 100;
		Integer threshold = 100;
		do {
			List<InAppNotification> notifications = notificationObjects.subList(fromIndex, toIndex);
			inAppNotificationsRepository.saveAll(notifications);
			fromIndex = toIndex;
			toIndex = ((threshold + toIndex) < notificationObjects.size()) ? (threshold + toIndex)
					: (notificationObjects.size());
		} while (fromIndex < notificationObjects.size());
	}

	@Override
	public Boolean readInAppNotification(String inAppNotificationId, String pushNotificationId, String userId,
			Boolean calendar, String applicationName) {
		utilityService.validateUserId(userId);
		utilityService.validateApplicationName(applicationName);
		utilityService.validateNotificationId(inAppNotificationId, pushNotificationId);
		InAppNotification notificationToRead = getNotificationToRead(userId, inAppNotificationId, pushNotificationId,
				calendar);
		if (!Objects.isNull(notificationToRead)) {
			notificationToRead.setIsRead(true);
			inAppNotificationsRepository.save(notificationToRead);
			return true;
		} else {
			throw new DataNotFoundException(Constants.NO_IN_APP_NOTIFICATION_FOUND_WITH_IN_APP_OR_PUSH_NOTIFICATION_ID);
		}
	}

	private InAppNotification getNotificationToRead(String userId, String inAppNotificationId,
			String pushNotificationId, Boolean calendar) {
		InAppNotification notificationToRead = null;
		if (StringUtils.isNotEmpty(inAppNotificationId)) {
			notificationToRead = (Boolean.TRUE.equals(calendar))
					? (inAppNotificationsRepository.findOneByOwnerIdAndInAppNotificationId(userId, inAppNotificationId))
					: (inAppNotificationsRepository.findOneByUserIdAndInAppNotificationId(userId, inAppNotificationId));
		} else {
			notificationToRead = inAppNotificationsRepository.findOneByUserIdAndPushNotificationId(userId,
					pushNotificationId);
		}
		return notificationToRead;
	}

	@Override
	public CountVO countInAppNotification(String applicationName, String userId, Boolean calendar) {
		utilityService.validateUserId(userId);
		utilityService.validateApplicationName(applicationName);
		CountVO inAppNotificationCount = null;
		int count = 0;
		count = (Boolean.TRUE.equals(calendar))
				? (inAppNotificationsRepository.countByOwnerIdAndIsReadAndIsClearAndApplicationNameIgnoreCase(userId,
						false, false, applicationName.toLowerCase()).size())
				: (inAppNotificationsRepository.countByUserIdAndIsReadAndIsClearAndApplicationNameIgnoreCase(userId,
						false, false, applicationName.toLowerCase()).size());
		inAppNotificationCount = new CountVO(count);
		return inAppNotificationCount;
	}
}