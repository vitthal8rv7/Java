package com.learn.java.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.learn.java.mail.config.PropertyHolder;
import com.learn.java.mail.model.EmailFields;
import com.learn.java.mail.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private PropertyHolder propertyHolder;

	
	@Autowired(required = true)
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(EmailFields emailFields) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		emailFields.getTo().stream().forEach(to -> {
			simpleMailMessage.setTo(to);
		});
		simpleMailMessage.setFrom(emailFields.getFrom());
		simpleMailMessage.setText(emailFields.getMailBody());
		simpleMailMessage.setSubject(emailFields.getSubject());
		System.out.println("Email sent successfully!");
		javaMailSender.send(simpleMailMessage);
	}
}