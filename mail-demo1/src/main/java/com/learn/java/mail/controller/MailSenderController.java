package com.learn.java.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.mail.model.EmailFields;
import com.learn.java.mail.service.EmailSenderService;

@RestController
@RequestMapping("/mail/sender/demo")
public class MailSenderController {

	@Autowired
	private EmailSenderService emailSenderService;

	@PostMapping("/send")
	public Boolean sendMail(@RequestBody EmailFields emailFields) {
		emailSenderService.sendMail(emailFields);
		return true;
	}

	@PostMapping("/send/html")
	public Boolean sendHtmlEmail(@RequestBody EmailFields emailFields) {
		emailSenderService.sendHtmlEmail(emailFields);
		return true;
	}

	@PostMapping("/send/with-attachment")
	public Boolean sendMailWithAttachment(@RequestBody EmailFields emailFields) {
		emailSenderService.sendMailWithAttachment(emailFields);
		return true;
	}

//	@PostMapping("/send/with-attachment2")
//	public Boolean sendMailWithAttachment2(@RequestBody EmailFields emailFields) {
//		emailService.sendMailWithAttachment2(emailFields);
//		return true;
//	}
//
//	@PostMapping("/read")
//	public Boolean readMail(@RequestBody EmailFields emailFields) {
//		emailService.readMail(emailFields);
//		return true;
//	}
//
//	@PostMapping("/forward")
//	public Boolean forwardMail(@RequestBody EmailFields emailFields) {
//		emailService.forwardMail(emailFields);
//		return true;
//	}
//
//	@DeleteMapping("/delete")
//	public Boolean deleteMail(@RequestBody EmailFields emailFields) {
//		emailService.deleteMail(emailFields);
//		return true;
//	}

}
