package com.learn.java.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.redis.service.BookService;

@RestController
@RequestMapping("/redis/demo")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book/list")
	List<String> bookList() {
		return bookService.getAllBooks();
	}
}
