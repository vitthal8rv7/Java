package com.learn.java.internationalisation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.internationalisation.service.InternationalisationService;

@RestController
@RequestMapping("/internationalisation/demo")
public class InternationalisationController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private InternationalisationService internationalisationService;

	@GetMapping("/locale/format")
	public String localeFormatDemo1() {
		internationalisationService.localeFormatDemo1(request.getHeader("lang"), request.getHeader("country"),
				request.getHeader("os"));
		return "Global Locale Format Tested Successfully.";
	}
	
	@GetMapping("/currency/format")
	public String currencyFormatDemo1() {
		internationalisationService.currencyFormatDemo1(request.getHeader("lang"), request.getHeader("country"),
	request.getHeader("os"));
		return "Global Currency Format Tested Successfully.";
	}
	
	@GetMapping("/number/format")
	public String numberFormatDemo1() {
		internationalisationService.numberFormatDemo1(request.getHeader("lang"), request.getHeader("country"),
	request.getHeader("os"));
		return "Global Number Format Tested Successfully.";
	}

	
	@GetMapping("/date/time/format")
	public String dateTimeFormatDemo1() {
		internationalisationService.dateTimeFormatDemo1(request.getHeader("lang"), request.getHeader("country"),
	request.getHeader("os"));
		return "Global Date and Time Format Tested Successfully.";
	}

	@GetMapping("/language/format")
	public String languageFormatDemo1() {
		internationalisationService.languageFormatDemo1(request.getHeader("lang"), request.getHeader("country"),
				request.getHeader("os"));
		return "Global Language Format Tested Successfully.";
	}


}
