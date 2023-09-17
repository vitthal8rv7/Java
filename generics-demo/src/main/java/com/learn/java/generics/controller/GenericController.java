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

		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(1);
		arrayList2.add(2);
		arrayList2.add(3);

		ArrayList<Double> arrayList3 = new ArrayList<>();
		arrayList3.add(1d);
		arrayList3.add(2d);
		arrayList3.add(3d);

		genericService.wildCartCharacterDemo(arrayList);
		genericService.wildCartCharacterDemo(arrayList2);
		genericService.wildCartCharacterDemo(arrayList3);

		// genericService.wildCartCharacterDemo2(arrayList);
		// The method wildCartCharacterDemo2(ArrayList<? extends Number>) in the type
		// GenericService is not applicable for the arguments (ArrayList<String>)
		genericService.wildCartCharacterDemo2(arrayList2);
		genericService.wildCartCharacterDemo2(arrayList3);

		return "Wild Card Character rules tested.";
	}

	@GetMapping("/parameter-type-scope")
	public String parameterTypeScopeDemo() {
		System.out.println("Inside Controller:: parameterTypeScopeDemo");
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Value");
		// arrayList.add(1d);
		// The method add(String) in the type ArrayList<String> is not applicable for
		// the arguments (double)

		ArrayList arrayList2 = new ArrayList();
		arrayList2.add("Value");
		arrayList2.add(1d);
		arrayList2.add(1);
		arrayList2.add(true);

		genericService.parameterTypeScopeDemo(arrayList); // caller parameter type doesn`t matter in called method
		genericService.parameterTypeScopeDemo(arrayList2); // caller parameter type doesn`t matter in called method

		genericService.parameterTypeScopeDemo2(arrayList); // caller parameter type doesn`t matter in called method
		genericService.parameterTypeScopeDemo2(arrayList2); // caller parameter type doesn`t matter in called method

		return "Parameter Type Scope rules tested.";
	}
}
