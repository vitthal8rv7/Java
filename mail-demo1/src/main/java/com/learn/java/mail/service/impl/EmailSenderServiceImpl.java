package com.learn.java.mail.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
		setMailProperties(simpleMailMessage, emailFields);
		javaMailSender.send(simpleMailMessage);
		System.out.println("Email sent successfully!");
	}

	@Override
	public void sendHtmlEmail(EmailFields emailFields) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			setMailProperties(helper, emailFields);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(message);
		System.out.println("Email sent successfully!");
	}
	
	private void setMailProperties(SimpleMailMessage simpleMailMessage, EmailFields emailFields) {
		emailFields.getTo().stream().forEach(to -> {
			simpleMailMessage.setTo(to);
		});
		simpleMailMessage.setFrom(emailFields.getFrom());
		simpleMailMessage.setText(emailFields.getMailBody());
		simpleMailMessage.setSubject(emailFields.getSubject());		
	}

	private void setMailProperties(MimeMessageHelper helper, EmailFields emailFields) throws MessagingException {
		emailFields.getTo().stream().forEach(to -> {
			try {
				helper.setTo(to);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		helper.setFrom(emailFields.getFrom());
		 helper.setText("<html><body><h1>Hello</h1></body></html>", true);
		//helper.setText(emailFields.getMailBody());
		helper.setSubject(emailFields.getSubject());				
	}
}