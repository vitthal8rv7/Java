package com.learn.java.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.swagger.model.Feedback;

@RestController
@RequestMapping(value = "/swagger/demo")
public class UrlEncodedController {

//	@GetMapping(path = "/feedback")
//	public String getFeedbackForm(Model model) {
//		Feedback feedback = new Feedback();
//		model.addAttribute("feedback", feedback);
//		System.out.println("In Feedback...");
//		return "model";
//	}

	@PostMapping(path = "/web/feedback", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<String> handleBrowserSubmissions(Feedback feedback) throws Exception {
		System.out.println("Save feedback data..." + feedback);
		return new ResponseEntity<String>("Thank you for submitting feedback.", HttpStatus.OK);
	}

	@PostMapping(path = "/feedback", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<String> handleNonBrowserSubmissions(@RequestParam MultiValueMap<String, String> paramMap)
			throws Exception {
		System.out.println("Save feedback data2..." + paramMap);
		return new ResponseEntity<String>("Thank you for submitting feedback2", HttpStatus.OK);
	}

}
