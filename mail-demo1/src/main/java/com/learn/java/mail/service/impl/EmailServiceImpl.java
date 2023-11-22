package com.learn.java.mail.service.impl;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.learn.java.mail.config.Constants;
import com.learn.java.mail.exception.AddressException;
import com.learn.java.mail.exception.BadRequestException;
import com.learn.java.mail.exception.InternalServerErrorException;
import com.learn.java.mail.model.EmailFields;
import com.learn.java.mail.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

//	@Autowired
//	private JavaMailSender javaMailSender;

	@Override
	public void sendMail(EmailFields emailFields) {
		// Set mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
     // Create a Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               // return new PasswordAuthentication("vitthalaradwad@gmail.com", "");
            	return new PasswordAuthentication("vitthalaradwad@gmail.com", "");
            	
            }
            
        });	
        
        try {
            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vitthalaradwad@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kirtichimle85@gmail.com"));
            message.setSubject("Test Email");
            message.setText("This is a test email sent using JavaMail API.");
//            message.setContent(multipart);

            // Connect to the SMTP server and send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

//	@Override
//	public void sendMail(EmailFields emailFields) {
//        try {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, Constants.UTF_8);
//            Multipart multipart = new MimeMultipart();
//
//            // Add HTML Body
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(emailFields.getMailBody(), "text/html; charset=UTF-8");
//            multipart.addBodyPart(messageBodyPart);
//
//            // Add attachment
//            if (!CollectionUtils.isEmpty(emailFields.getFileDetails())) {
//                emailFields.getFileDetails().stream().forEach(file -> {
//                    try {
//                        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//                        DataSource ds = new ByteArrayDataSource(file.getFileBytes(), file.getMimeType());
//                        attachmentBodyPart.setDataHandler(new DataHandler(ds));
//                        attachmentBodyPart.setFileName(file.getFileName());
//                        multipart.addBodyPart(attachmentBodyPart);
//                    } catch (Exception e) {
//                		String error = "Error occurred while adding file in MimeBodyPart";
//                		throw new InternalServerErrorException(error);
//                    }
//                });
//            }
//
//            mimeMessage.setContent(multipart);
//
//            String[] toArray = emailFields.getTo().toArray(new String[emailFields.getTo().size()]);
//            helper.setTo(toArray);
//
//            if (!CollectionUtils.isEmpty(emailFields.getCc())) {
//                String[] ccArray = emailFields.getCc().toArray(new String[emailFields.getCc().size()]);
//                helper.setCc(ccArray);
//            }
//
//            if (StringUtils.isNotBlank(emailFields.getPersonalName())) {
//                helper.setFrom(emailFields.getFrom(), emailFields.getPersonalName());
//            } else {
//                helper.setFrom(emailFields.getFrom());
//            }
//            helper.setSubject(emailFields.getSubject());
//
//            javaMailSender.send(mimeMessage);
//        } catch (AddressException e) {
//            String error = "Invalid to address, missing domain with email body";
//    		throw new BadRequestException(error);
//        } catch (Exception e) {
//            String error = "Error Sending Email";
//    		throw new InternalServerErrorException(error);
//        }
//	}

}
