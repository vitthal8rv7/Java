package com.learn.java.swagger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/swagger/demo")
public class Controller2 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/info/with-response-body")
	@ResponseBody
	public String getInfoWithResponseBody() {
		System.out.println("In info with-response-body");
		return "Result With Response Body";
	}

	@GetMapping("/info/without-response-body") // 404 Not Found Error Occurred Due To Response Not Sent To Client
												// (To Send Response, We Need to add @ResponseBody).
	public String getInfoWithoutResponseBody() {
		System.out.println("In info without-response-body");
		return "Result Without Response Body";
	}

	@GetMapping("/info/with-diff-accept-header")
	@ResponseBody
	public String getInfoWithAcceptHeader() {
		System.out.println("In info with-diff-accept-header");
		System.out.println("accept-header: " + request.getHeader("Accept")); // Default Application/Json
		return "Result Depends On Accept Header Type.";
	}

	@GetMapping("/timeout/check1")
	@ResponseBody
	public String testTimeout1() {
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost + "/rest/demo/timeout/check1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity,
					String.class);
		} catch (Exception e) {
			System.out.println("Execption: " + e);
			throw e;
		}
		if (response == null) {
			return null;
		} else {
			return response.getBody();
		}
	}
}