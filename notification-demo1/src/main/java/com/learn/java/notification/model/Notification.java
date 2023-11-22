package com.learn.java.notification.model;

import java.io.Serializable;
import java.util.List;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public boolean isContentAvailable() {
		return contentAvailable;
	}

	public void setContentAvailable(boolean contentAvailable) {
		this.contentAvailable = contentAvailable;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", title=" + title + ", body=" + body + ", type=" + type + ", imageId="
				+ imageId + ", commentId=" + commentId + ", notificationId=" + notificationId + ", contentAvailable="
				+ contentAvailable + ", priority=" + priority + ", applicationName=" + applicationName + "]";
	}

	public NotificationRequest getNotificationRequest(Notification notification,
			List<String> deviceTokensToSendNotification, Long currentTimeInMillies) {
		NotificationRequest notificationRequest = new NotificationRequest();
		notificationRequest.setRegistrationIds(deviceTokensToSendNotification);
		notificationRequest.setNotification(notification);
		notificationRequest.setData(notification);
		notificationRequest.setSentOn(currentTimeInMillies.toString());
		return notificationRequest;
	}
}
