package com.learn.java.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.swagger.model.EmployeeListResponse;
import com.learn.java.swagger.service.PaginationService;

@RestController
@RequestMapping("/swagger/demo")
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

	@GetMapping(value = "/employee/list2")
	public EmployeeListResponse getEmployeeList(Pageable pageable) {
		System.out.println("In getEmployeeList: Pageable: " + pageable);
		return paginationService.getEmployeeList(pageable);
	}

	@GetMapping(value = "/employee/list-from-app2")
	public String getEmployeeListFromApp2(Pageable pageable) {
		System.out.println("In getEmployeeList: Pageable: " + pageable);
		return paginationService.getEmployeeListFromApp2(pageable);
	}

	@GetMapping(value = "/employee/pageable/list-from-app2")
	public EmployeeListResponse getEmployeeListPageableFromApp2(Pageable pageable) {
		System.out.println("In getEmployeeList: Pageable: " + pageable);
		return paginationService.getEmployeeListPageableFromApp2(pageable);
	}

}
