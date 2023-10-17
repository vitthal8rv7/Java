package com.learn.java.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class Controller {

	@Autowired
	private HttpServletResponse httpServletResponse;
	
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
	
	//a query parameter 'id'
	@GetMapping("/request-param/employee-id")
	public String getEmployeeId(@RequestParam String id) { //a query parameter name should be id and local name is also id
		System.out.println("In get Employee Id");
		System.out.println("Employee Id: "+id);
		String result = String.format("Employee Id: %s \n", id);
		result = result + "\nEmployee Id Via Request Param Tested Sucessfully.";
		return result;
	}
	
	//a query parameter 'id'
	@GetMapping("/request-param/employee-id-with-name")
	public String getEmployeeIdWithName(@RequestParam(name = "id") String localId) { 
									//a query parameter name should be id and local name is localId
		System.out.println("In get Employee Id");
		System.out.println("Employee Id: "+localId);
		String result = String.format("Employee Id: %s \n", localId);
		result = result + "\nEmployee Id Via Request Param Tested Sucessfully.";
		return result;
	}
	
	//a query parameter 'id'
	@GetMapping("/request-param/employee-optional-id")
	public String getEmployeeIdOptional(@RequestParam(required = false) String id) { //error if id not sent in request but by making it optional, 
																//we provide more flexible and error free code.
		System.out.println("In get Employee Id");
		System.out.println("Employee Id: "+id);
		String result = String.format("Employee Id: %s \n", id);
		result = result + "\nEmployee Id Via Request Param Tested Sucessfully.";
		return result;
	}
	
	//a query parameter 'id'
	@GetMapping("/request-param/default-value-id")
	public String getEmployeeIdWithDefaultValue(@RequestParam(defaultValue = "id1234") String id) { //a query parameter name should be id and local name is also id
		System.out.println("In get Employee Id");
		System.out.println("Employee Id: "+id);
		String result = String.format("Employee Id: %s \n", id);
		result = result + "\nEmployee Id Via Request Param Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/request-param/map-all-params")
	public String getRequestParamsByMap(@RequestParam Map<String,String> allParams) { 
		System.out.println("In get Employee Id");
		System.out.println("all params: "+allParams);
		String result = String.format("all params : %s \n", allParams);
		result = result + "\nAll Params Via Request Param Tested Sucessfully.";
		return result;
	}
	
	@GetMapping("/request-param/multi-value")
	public String getMultiValueRequestParams(@RequestParam List<String> id) { 
		System.out.println("In get Employee Id");
		System.out.println("all params: "+id);
		String result = String.format("all params : %s \n", id);
		result = result + "\nMulti Valued All Params Via Request Param Tested Sucessfully.";
		return result;
	}
	
	@RequestMapping(path = "/request-header/multi-value", headers = "Accept=application/json",  method = { RequestMethod.PUT, RequestMethod.POST })
	public String restrictRequestByHeaders(@RequestParam List<String> id) { 
		System.out.println("In get Employee Id");
		System.out.println("all params: "+id);
		String result = String.format("all params : %s \n", id);
		result = result + "\nRequest Headers Tested Sucessfully.";
		return result;
	}
	
	@RequestMapping(path = "/**", headers = "Accept=application/json",  method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
	public String fallbackForAllRequests(@RequestParam List<String> id) { 
		System.out.println("In get Employee Id");
		System.out.println("all params: "+id);
		String result = String.format("all params : %s \n", id);
		result = result + "\nRequest Headers Tested Sucessfully.";
		return result;
	}
	
	@GetMapping(path = "/duplicate/diff-media-type",  produces = MediaType.APPLICATION_JSON_VALUE)
	public String duplicateUrlWithDiffMediaTypeJson(@RequestParam List<String> id) { 
		System.out.println("JSON");
		System.out.println("all params: "+id);
		String result = String.format("duplicate media types: all params : %s \n", id);
		result = result + "\nUrl Duplication With Diff Media Type(JSON) Tested Sucessfully.";
		return result;
	}
	
	@GetMapping(path = "/duplicate/diff-media-type",  produces = MediaType.APPLICATION_XML_VALUE)
	public String duplicateUrlWithDiffMediaTypeXML(@RequestParam List<String> id) { 
		System.out.println("XML");
		System.out.println("all params: "+id);
		String result = String.format("duplicate media types: all params : %s \n", id);
		result = result + "\nUrl Duplication With Diff Media Type(XML) Tested Sucessfully.";
		return result;
	}
	
	
	@GetMapping("/set-headers/with-response-entity")
	public ResponseEntity<String> setHeadersWithResponseEntity() {
		System.out.println("set-headers with-response-entity");
		return ResponseEntity.ok()
							 .header("Custom-Header", "foo")
							 .body("Custom header set");
	}
	
	@GetMapping("/set-headers/with-response-entity2")
	public ResponseEntity<String> setHeadersWithResponseEntity2() {
		System.out.println("set-headers with-response-entity2");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header2", "foo2");
		return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);

	}
	
	@GetMapping("/set-headers/with-http-response")
	public String setHeadersWithHttpResponse() {
		System.out.println("set-headers with-http-response");
		httpServletResponse.setHeader("Custom-Header3", "foo3");
		return "Custom header set";

	}
}
