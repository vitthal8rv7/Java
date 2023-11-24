package com.learn.java.mail.service;

import com.learn.java.mail.model.EmailFields;

public interface EmailService {

    public void sendMail(EmailFields emailFields);

	public void sendMailWithAttachment(EmailFields emailFields);

	public void sendMailWithAttachment2(EmailFields emailFields);

	public void readMail(EmailFields emailFields);

	public void forwardMail(EmailFields emailFields);

}
