package com.learn.java.notification.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationVO implements Serializable {

	private static final long serialVersionUID = -8775725502099729050L;

	private String body;

	private String title;

	private String type;

	private String id;

	private String imageId;

	private String commentId;

	private String notificationId;

	@JsonProperty("available_content")
	private boolean contentAvailable;

	private String priority;

	private String applicationName;

}
