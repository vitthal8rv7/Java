package com.learn.java.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learn.java.rest.model.Item;
import com.learn.java.rest.model.Item2;

@RestController
@RequestMapping(value = "/rest/demo", produces = "application/vnd.item.api.v1+json")
public class RequestResponseTypesControllerV1 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private HttpServletResponse httpServletResponse;

	@RequestMapping(method = RequestMethod.GET, value = "/controller/get/items/{id}")
	@ResponseBody
	public Item getItem(@PathVariable("id") String id) {
		return new Item();
	}
}
