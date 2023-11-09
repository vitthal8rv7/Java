package com.learn.java.swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
@RequestMapping("/rest/demo")
public class IdempotentController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/idempotent/test")
	@ResponseBody
	public List<String> testidempotent() {
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost + "/rest/demo/idempotent/test");
		HttpHeaders headers = new HttpHeaders();
		String idempotencyKey = UUID.randomUUID().toString() + System.currentTimeMillis();
		headers.set("Idempotency-Key", idempotencyKey);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		List<String> responses = new ArrayList<>();
		ResponseEntity<String> response = null;

		try {
			for (int i = 0; i < 5; i++) {
				response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity,
						String.class);
				responses.add(i, response.getBody());
			}
		} catch (Exception e) {
			System.out.println("Execption: " + e);
			throw e;
		}
		return responses;
	}
}