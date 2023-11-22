/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mindstix Software Labs
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetail implements Serializable {

    private static final long serialVersionUID = -8968416106283194740L;

    private String id;

    private String firstName;

    private String lastName;

    private String workEmailAddress;

    private String commentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWorkEmailAddress() {
		return workEmailAddress;
	}

	public void setWorkEmailAddress(String workEmailAddress) {
		this.workEmailAddress = workEmailAddress;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", workEmailAddress="
				+ workEmailAddress + ", commentId=" + commentId + "]";
	}
}