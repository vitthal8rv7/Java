package com.learn.java.mail.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;


public class FileDetail implements Serializable {

	private static final long serialVersionUID = -3417791774971590498L;

	private byte[] filebyte;

	private String fileName;

	private String fileUrl;

	private long size;

	private String mimeType;

	/**
	 * @return filebyte
	 */
	public byte[] getFileBytes() {
		return filebyte;
	}

	/**
	 * @param fileBytes
	 * @param fileName
	 */
	public FileDetail(byte[] fileBytes, String fileName) {
		super();
		this.filebyte = fileBytes;
		this.fileName = fileName;
	}

	/**
	 * @param fileName
	 * @param fileUrl
	 */
	public FileDetail(String fileName, String fileUrl) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}

	/**
	 * @param fileBytes
	 * @param fileName
	 * @param size
	 */
	public FileDetail(byte[] fileBytes, String fileName, long size) {
		super();
		this.filebyte = fileBytes;
		this.fileName = fileName;
		this.size = size;
	}
	
	public byte[] getFilebyte() {
		return filebyte;
	}

	public void setFilebyte(byte[] filebyte) {
		this.filebyte = filebyte;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
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