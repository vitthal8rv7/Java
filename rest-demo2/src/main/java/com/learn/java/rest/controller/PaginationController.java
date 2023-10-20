package com.learn.java.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.rest.model.EmployeeListResponse;
import com.learn.java.rest.service.PaginationService;

@RestController
@RequestMapping("/rest/demo")
public class PaginationController {
	
	@Autowired
	private PaginationService paginationService;

//	@Autowired
//	private HttpServletResponse httpServletResponse;

    @GetMapping(value = "/employee/list")
    public EmployeeListResponse getEmployeeList(Pageable pageable,
            @RequestParam(required = false) String someRequestParam) { 
    	System.out.println("In getEmployeeList: someRequestParam: " + someRequestParam);
    	System.out.println("In getEmployeeList: Pageable: " + pageable);
    	return paginationService.getEmployeeList(pageable, someRequestParam);
    }
}
