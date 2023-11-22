package com.learn.java.mail.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mail.config.PropertyHolder;
import com.learn.java.mail.model.EmailFields;
import com.learn.java.mail.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private PropertyHolder propertyHolder;
	
	@Override
	public void sendMail(EmailFields emailFields) {
		// Set mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", propertyHolder.getHost());
        properties.put("mail.smtp.port", propertyHolder.getPort());
        properties.put("mail.smtp.auth", propertyHolder.getAuth());
        properties.put("mail.smtp.starttls.enable", propertyHolder.getStartTls());
        
     // Create a Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               // return new PasswordAuthentication("vitthalaradwad@gmail.com", "");
            	return new PasswordAuthentication(propertyHolder.getMailFrom(), propertyHolder.getMailPwd());
            	
            }
            
        });	
        
        try {
            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(propertyHolder.getMailFrom()));
            if(CollectionUtils.isNotEmpty(emailFields.getTo())) {
            	for(String to: emailFields.getTo()) {
            		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            	}
            } else {
            	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(propertyHolder.getMailTo()));
            }            
            message.setSubject(emailFields.getSubject());
            message.setText(emailFields.getMailBody());

            // Connect to the SMTP server and send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}