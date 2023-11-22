package com.learn.java.notification.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class NotificationRequest implements Serializable {

	private static final long serialVersionUID = 6173931877998003701L;

	@Id
	private String id;

	@JsonProperty("registration_ids")
	private List<String> registrationIds;

	@JsonProperty("topic")
	private String topic;

	@JsonProperty("notification")
	private Notification notification;

	private Object data;

	private String sentOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getRegistrationIds() {
		return registrationIds;
	}

	public void setRegistrationIds(List<String> registrationIds) {
		this.registrationIds = registrationIds;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSentOn() {
		return sentOn;
	}

	public void setSentOn(String sentOn) {
		this.sentOn = sentOn;
	}

	@Override
	public String toString() {
		return "NotificationRequest [id=" + id + ", registrationIds=" + registrationIds + ", topic=" + topic
				+ ", notification=" + notification + ", data=" + data + ", sentOn=" + sentOn + "]";
	}
}