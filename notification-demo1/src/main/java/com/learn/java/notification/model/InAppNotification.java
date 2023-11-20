package com.learn.java.notification.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InAppNotification {

	private String id;

	private String title;

	private String body;

	private String type;

	private String imageId = "";

	private String commentId = "";

	private String notificationId;

	@JsonProperty("available_content")
	private boolean contentAvailable;

	private String priority;

	private String inAppNotificationId;

	private String pushNotificationId;

	private Boolean isRead = false;

	private Boolean isClear = false;

	private Long sentOn;

	private String userId;

	private String contentType;

	private String ownerId;

	private String applicationName;

}
