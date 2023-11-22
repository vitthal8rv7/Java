package com.learn.java.mail.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.springframework.web.multipart.MultipartFile;

public class EmailFields implements Serializable {

	private static final long serialVersionUID = -2146652210774513406L;

	private List<String> to;

	private List<String> bcc;

	private String from;

	private String personalName;

	private String mailType;

	private String subject;

	private List<String> cc;

	private List<MultipartFile> files;

	private List<FileDetail> fileDetails;

	private List<FileDetail> images;

	private List<FileDetail> attachments;

	private String mailBody;

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<FileDetail> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FileDetail> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public List<FileDetail> getImages() {
		return images;
	}

	public void setImages(List<FileDetail> images) {
		this.images = images;
	}

	public List<FileDetail> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<FileDetail> attachments) {
		this.attachments = attachments;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	@Override
	public String toString() {
		StandardToStringStyle style = new StandardToStringStyle();
		style.setFieldSeparator(", ");
		style.setUseClassName(false);
		style.setUseIdentityHashCode(false);
		return new ReflectionToStringBuilder(this, style).toString();
	}
}