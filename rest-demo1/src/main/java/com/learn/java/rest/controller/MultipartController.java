package com.learn.java.rest.controller;

import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.learn.java.rest.model.Employee;

@RestController
@RequestMapping("/rest/demo")
public class MultipartController {

//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Autowired
//	private HttpServletRequest httpServletRequest;
//
//	@Autowired
//	private HttpServletResponse httpServletResponse;

	@PostMapping(value= "/employee/multipart2")
	public Employee setEmployeePicture2(@RequestParam(value = "image", required = true) MultipartFile image) {
		Employee employee = new Employee();
		System.out.println("In Multipart \nEmployee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"/rest/demo/employee/multipart2");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
//        Map<String, Object> form = new LinkedHashMap<>();
//        form.put("image", image);
        System.out.println("multipart name: "+image.getName());
        form.add(image.getName(), image.getResource());
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, headers);
//        HttpEntity<MultipartFile> requestEntity = new HttpEntity<>(image, headers);
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(form, headers);
        ResponseEntity<Employee> response = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            //response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity, Employee.class);
        	response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity, Employee.class);
        } catch (Exception e) {
        	System.out.println("Execption: "+e);
            //LOGGER.error(Constants.ERROR_OCCURRED_WHILE_CALLING_CONTENT_LOCKER_SERVICE, e);
            //throw new InternalServerErrorException(propertyHolder.getTrmwInternalServerErrorCode(), propertyHolder.getTrmwInternalServerErrorMessage());
        }
        //LOGGER.info("Received response from sdvm service to upload multiple photos");
        if (response == null) {
          //  return new SdvmContentUploadResponse();
        	return null;	
        } else {
            return response.getBody();
        }
	}
	
	@PostMapping(value= "/employee/multipart")
	public Employee setEmployeePicture(@RequestParam(value = "image", required = true) MultipartFile image) {
		Employee employee = new Employee();
		System.out.println("In Multipart \nEmployee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"/rest/demo/employee/multipart");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
//        Map<String, Object> form = new LinkedHashMap<>();
//        form.put("image", image);
        System.out.println("multipart name: "+image.getName());
        form.add(image.getName(), image.getResource());
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, headers);
//        HttpEntity<MultipartFile> requestEntity = new HttpEntity<>(image, headers);
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(form, headers);
        ResponseEntity<Employee> response = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            //response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity, Employee.class);
        	response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity, Employee.class);
        } catch (Exception e) {
        	System.out.println("Execption: "+e);
            //LOGGER.error(Constants.ERROR_OCCURRED_WHILE_CALLING_CONTENT_LOCKER_SERVICE, e);
            //throw new InternalServerErrorException(propertyHolder.getTrmwInternalServerErrorCode(), propertyHolder.getTrmwInternalServerErrorMessage());
        }
        //LOGGER.info("Received response from sdvm service to upload multiple photos");
        if (response == null) {
          //  return new SdvmContentUploadResponse();
        	return null;	
        } else {
            return response.getBody();
        }
	}
}
