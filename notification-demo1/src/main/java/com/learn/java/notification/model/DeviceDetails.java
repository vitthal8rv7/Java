package com.learn.java.notification.model;

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
public class DeviceDetails {

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

}
