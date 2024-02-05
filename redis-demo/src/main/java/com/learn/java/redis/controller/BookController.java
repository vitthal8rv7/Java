package com.learn.java.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.redis.service.BookService;
import com.learn.java.redis.service.CompanyService;

@RestController
@RequestMapping("/redis/demo")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/book/list")
	List<String> bookList() {
		return bookService.getAllBooks();
	}

	@GetMapping("/book")
	String bookList(@RequestParam(name = "id") String id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/company/name")
	String getCompanyName() {
		return companyService.getCompanyName();
	}


}
