package com.learn.java.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/demo")
public class Controller2 {

	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/info/with-response-body")
	@ResponseBody
	public String getInfoWithResponseBody() {
		System.out.println("In info with-response-body");
		return "Result With Response Body";
	}
	
	@GetMapping("/info/without-response-body")    // 404 Not Found Error Occurred Due To Response Not Sent To Client
													//(To Send Response, We Need to add @ResponseBody).
	public String getInfoWithoutResponseBody() {
		System.out.println("In info without-response-body");
		return "Result Without Response Body";
	}
	
	@GetMapping("/info/with-diff-accept-header")
	@ResponseBody
	public String getInfoWithAcceptHeader() {
		System.out.println("In info with-diff-accept-header");
		System.out.println("accept-header: "+request.getHeader("Accept")); //Default Application/Json
		return "Result Depends On Accept Header Type.";
	}
}
