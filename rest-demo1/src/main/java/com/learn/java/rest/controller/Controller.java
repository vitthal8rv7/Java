package com.learn.java.rest.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class Controller {

	@GetMapping("/info/with-rest-controller")
	public String getWithRestController() {
		System.out.println("In info with-rest-controller");
		return "Result With Rest Controller and Response Body.";
	}
	
	@GetMapping("/path-variable/employee/{id}/{name}")
	public String getEmployeeIdAndNameViaPathVeriable(@PathVariable String id, @PathVariable String name) {
		System.out.println("In get Employee Id And Name Via PathVeriable");
		System.out.println("Employee Id: "+id + "\nEmployee name: "+name);
		String result = String.format("Employee Id: %s \nEmployee name: %s", id, name);
		result = result + "\nEmployee Id And Name Via PathVeriable Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/path-variable/employee/{id}/{name}/map")
	public String getEmployeeIdAndNameInMapViaPathVeriable(@PathVariable Map<String, String> pathVarsMap) {
		System.out.println("In get Employee Id And Name Via PathVeriable");
		System.out.println("Employee Id: "+pathVarsMap.get("id") + "\nEmployee name: "+pathVarsMap.get("name"));
		String result = String.format("Employee Id: %s \nEmployee name: %s", pathVarsMap.get("id"), pathVarsMap.get("name"));
		result = result + "\nEmployee Id And Name Via PathVeriable Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/path-variable/employee/{id}/{name}/required")
	public String isRequiredPathVeriable(@PathVariable(required = false) String id, @PathVariable(required = false) String name) {
		System.out.println("In get Employee Id And Name Via PathVeriable");
		System.out.println("Employee Id: "+id + "\nEmployee name: "+name);
		String result = String.format("Employee Id: %s \nEmployee name: %s", id, name);
		result = result + "\nEmployee Id And Name Via PathVeriable Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/path-variable/employee/{id}/{name}/optional")
	public String optionalPathVeriable(@PathVariable(required = false) Optional<String> id, @PathVariable Optional<String> name) {
		System.out.println("In get Employee Id And Name Via PathVeriable");
		System.out.println("is Id Present: "+ id.isPresent());
		System.out.println("is Name Present: "+ name.isPresent());
		System.out.println("Employee Id: "+id.get() + "\nEmployee name: "+name.get());
		String result = String.format("Employee Id: %s \nEmployee name: %s", id.get(), name.get());
		result = result + "\nEmployee Id And Name Via PathVeriable Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/path-variable/employee/{id:[\\d]+}/{name}/regex")
	public String regexPathVeriable(@PathVariable String id, @PathVariable String name) {
		System.out.println("In get Employee Id And Name Via PathVeriable");
		System.out.println("Employee Id: "+id + "\nEmployee name: "+name);
		String result = String.format("Employee Id: %s \nEmployee name: %s", id, name);
		result = result + "\nEmployee Id And Name Via PathVeriable Tested Sucessfully.";
		return result;
	}
	
}
