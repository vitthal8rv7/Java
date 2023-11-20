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
public class Notification implements Serializable {

	private static final long serialVersionUID = 3599865768739614277L;

	private String id;

	private String title;

	private String body;

	private String type;

	private String imageId;

	private String commentId;

	private String notificationId;

	@JsonProperty("available_content")
	private boolean contentAvailable;

	private String priority;

	private String applicationName;

}
