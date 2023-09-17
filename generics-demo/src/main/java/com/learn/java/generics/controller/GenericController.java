package com.learn.java.generics.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.generics.service.GenericService;

@RestController
@RequestMapping("/generic/demo")
public class GenericController {

	@Autowired
	private GenericService genericService;
	
	@GetMapping("/basic-rules")
	public String genericDemo() {
		System.out.println("Inside Controller:: genericDemo1");
		genericService.testBasicRules();
		return "Generics basic rules tested.";
	}
	
	
	@GetMapping("/bound-parameter-type-rules")
	public String boundParameterTypeDemo() {
		System.out.println("Inside Controller:: boundParameterTypeDemo1");
		genericService.boundParameterTypeDemo();
		return "Bound Parameter Type rules tested.";
	}
	
	@GetMapping("/wild-card-character")
	public String wildCardCharacterDemo() {
		System.out.println("Inside Controller:: wildCardCharacterDemo");
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Value1");
		arrayList.add("Value2");
		arrayList.add("Value3");
		genericService.wildCartCharacterDemo(arrayList);

		
		
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(1);
		arrayList2.add(2);
		arrayList2.add(3);
		genericService.wildCartCharacterDemo(arrayList2);

		return "Wild Card Character rules tested.";
	}
}
