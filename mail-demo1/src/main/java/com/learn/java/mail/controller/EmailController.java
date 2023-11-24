package com.learn.java.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.mail.model.EmailFields;
import com.learn.java.mail.service.EmailService;

@RestController
@RequestMapping("/email/demo")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public Boolean sendMail(@RequestBody EmailFields emailFields) {
		emailService.sendMail(emailFields);
		return true;
	}

	@PostMapping("/send/with-attachment")
	public Boolean sendMailWithAttachment(@RequestBody EmailFields emailFields) {
		emailService.sendMailWithAttachment(emailFields);
		return true;
	}

	@PostMapping("/send/with-attachment2")
	public Boolean sendMailWithAttachment2(@RequestBody EmailFields emailFields) {
		emailService.sendMailWithAttachment2(emailFields);
		return true;
	}

	@PostMapping("/read")
	public Boolean readMail(@RequestBody EmailFields emailFields) {
		emailService.readMail(emailFields);
		return true;
	}

	@PostMapping("/forward")
	public Boolean forwardMail(@RequestBody EmailFields emailFields) {
		emailService.forwardMail(emailFields);
		return true;
	}

}
