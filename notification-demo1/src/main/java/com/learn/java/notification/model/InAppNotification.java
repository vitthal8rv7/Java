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

	public String getInAppNotificationId() {
		return inAppNotificationId;
	}

	public void setInAppNotificationId(String inAppNotificationId) {
		this.inAppNotificationId = inAppNotificationId;
	}

	public String getPushNotificationId() {
		return pushNotificationId;
	}

	public void setPushNotificationId(String pushNotificationId) {
		this.pushNotificationId = pushNotificationId;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Boolean getIsClear() {
		return isClear;
	}

	public void setIsClear(Boolean isClear) {
		this.isClear = isClear;
	}

	public Long getSentOn() {
		return sentOn;
	}

	public void setSentOn(Long sentOn) {
		this.sentOn = sentOn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "InAppNotificationVO [id=" + id + ", title=" + title + ", body=" + body + ", type=" + type + ", imageId="
				+ imageId + ", commentId=" + commentId + ", notificationId=" + notificationId + ", contentAvailable="
				+ contentAvailable + ", priority=" + priority + ", inAppNotificationId=" + inAppNotificationId
				+ ", pushNotificationId=" + pushNotificationId + ", isRead=" + isRead + ", isClear=" + isClear
				+ ", sentOn=" + sentOn + ", userId=" + userId + ", contentType=" + contentType + ", ownerId=" + ownerId
				+ ", applicationName=" + applicationName + "]";
	}

	public InAppNotificationVO getNotificationVO() {
		InAppNotificationVO inAppNotificationVO = new InAppNotificationVO();
		inAppNotificationVO.setId(commentId);
		inAppNotificationVO.setTitle(title);
		inAppNotificationVO.setBody(body);
		inAppNotificationVO.setType(type);
		inAppNotificationVO.setImageId(imageId);
		inAppNotificationVO.setCommentId(commentId);
		inAppNotificationVO.setNotificationId(notificationId);
		inAppNotificationVO.setContentAvailable(contentAvailable);
		inAppNotificationVO.setPriority(priority);
		inAppNotificationVO.setInAppNotificationId(inAppNotificationId);
		inAppNotificationVO.setPushNotificationId(pushNotificationId);
		inAppNotificationVO.setIsRead(isRead);
		inAppNotificationVO.setIsClear(isClear);
		inAppNotificationVO.setSentOn(sentOn);
		inAppNotificationVO.setUserId(userId);
		inAppNotificationVO.setContentType(contentType);
		inAppNotificationVO.setOwnerId(ownerId);
		inAppNotificationVO.setApplicationName(applicationName);
		return inAppNotificationVO;
	}

}
