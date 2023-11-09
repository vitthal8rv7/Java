package com.learn.java.swagger.model;

public class Feedback {

	private String emailId;

	private String comment;

	public Feedback() {

	}

	public Feedback(String emailId, String comment) {
		super();
		this.emailId = emailId;
		this.comment = comment;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Feedback [emailId=" + emailId + ", comment=" + comment + "]";
	}

}
