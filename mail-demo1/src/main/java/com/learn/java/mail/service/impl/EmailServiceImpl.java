package com.learn.java.mail.service.impl;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
		Properties properties = getProperties();

		// Create a Session
		Session session = getSession(properties);

		// Create a MimeMessage
		MimeMessage message = getMimeMessage(emailFields, session);

		try {
			// Connect to the SMTP server and send the message
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private MimeMessage getMimeMessage(EmailFields emailFields, Session session) {
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(propertyHolder.getMailFrom()));
			if (CollectionUtils.isNotEmpty(emailFields.getTo())) {
				for (String to : emailFields.getTo()) {
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				}
			} else {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(propertyHolder.getMailTo()));
			}
			message.setSubject(emailFields.getSubject());
			message.setText(emailFields.getMailBody());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}

	private Session getSession(Properties properties) {
		return Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// return new PasswordAuthentication("vitthalaradwad@gmail.com", "");
				return new PasswordAuthentication(propertyHolder.getMailFrom(), propertyHolder.getMailPwd());

			}

		});
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", propertyHolder.getHost());
		properties.put("mail.smtp.port", propertyHolder.getPort());
		properties.put("mail.smtp.auth", propertyHolder.getAuth());
		properties.put("mail.smtp.starttls.enable", propertyHolder.getStartTls());
		return properties;
	}

	@Override
	public void sendMailWithAttachment(EmailFields emailFields) {
		Properties properties = getProperties();
		Session session = getSession(properties);
		MimeMessage message = getMimeMessage(emailFields, session);
		addAttachments(message);
		try {
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void addAttachments(MimeMessage message) {
		try {
			//Override mail body
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("This is message body 12345");
			
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		    String filename = "feedback.html";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  

		    
			MimeBodyPart messageBodyPart3 = new MimeBodyPart();  
		    String filename3 = "jls8.pdf";//change accordingly  
		    DataSource source3 = new FileDataSource(filename3);  
		    messageBodyPart3.setDataHandler(new DataHandler(source3));  
		    messageBodyPart3.setFileName(filename3);  

		    
//			MimeBodyPart messageBodyPart = new MimeBodyPart();
//			try {
//				messageBodyPart.attachFile(new File("feedback.html"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			messageBodyPart.setHeader("Content-Type", "text/plain; charset=\"us-ascii\"; name=\"feedback.html\"");

			Multipart multipart = new MimeMultipart();
			 multipart.addBodyPart(messageBodyPart1);
			 multipart.addBodyPart(messageBodyPart2);
			 multipart.addBodyPart(messageBodyPart3);
			message.setContent(multipart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("in attachment error");
			e.printStackTrace();
		}
	}
}