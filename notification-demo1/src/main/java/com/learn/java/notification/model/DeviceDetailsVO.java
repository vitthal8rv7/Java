package com.learn.java.notification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDetailsVO implements Serializable {

	private static final long serialVersionUID = 6430910729124362966L;

	@NonNull
	private String deviceTokenNew;

	private String deviceTokenOld;

	@NonNull
	private String username;

	@NonNull
	private String osName;

	@NonNull
	private String modelName;

	@NonNull
	private String accessToken;

	@NonNull
	private String osVersion;

	private Long lastActive;

	private Long lastNudge;

	private String timezone;

	private List<String> notificationIds = new ArrayList<>();

	private String applicationName;

	public String getDeviceTokenNew() {
		return deviceTokenNew;
	}

	public void setDeviceTokenNew(String deviceTokenNew) {
		this.deviceTokenNew = deviceTokenNew;
	}

	public String getDeviceTokenOld() {
		return deviceTokenOld;
	}

	public void setDeviceTokenOld(String deviceTokenOld) {
		this.deviceTokenOld = deviceTokenOld;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public Long getLastActive() {
		return lastActive;
	}

	public void setLastActive(Long lastActive) {
		this.lastActive = lastActive;
	}

	public Long getLastNudge() {
		return lastNudge;
	}

	public void setLastNudge(Long lastNudge) {
		this.lastNudge = lastNudge;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public List<String> getNotificationIds() {
		return notificationIds;
	}

	public void setNotificationIds(List<String> notificationIds) {
		this.notificationIds = notificationIds;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "DeviceDetailsRO [deviceTokenNew=" + deviceTokenNew + ", deviceTokenOld=" + deviceTokenOld
				+ ", username=" + username + ", osName=" + osName + ", modelName=" + modelName + ", accessToken="
				+ accessToken + ", osVersion=" + osVersion + ", lastActive=" + lastActive + ", lastNudge=" + lastNudge
				+ ", timezone=" + timezone + ", notificationIds=" + notificationIds + ", applicationName="
				+ applicationName + "]";
	}
}
