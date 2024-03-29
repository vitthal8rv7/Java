package com.learn.java.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.redis.service.BookService;
import com.learn.java.redis.service.CompanyService;
import com.learn.java.redis.service.UserService;

@RestController
@RequestMapping("/redis/demo")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private UserService userService;

	@CacheEvict(value = "*", allEntries = true, beforeInvocation = true)
	@GetMapping("/cacheEvictAll")
	String cacheEvictAll() {
		System.out.println("Inside cacheEvictAll Method.");
		return "All Cache Evicted.";
	}

	@GetMapping("/book/list")
	List<String> bookList() {
		return bookService.getAllBooks();
	}

	@GetMapping("/book")
	String bookName(@RequestParam(name = "id") String id) {
		return bookService.getBookById(id);
	}

	@PutMapping("/book")
	String updateBookName(@RequestParam(name = "id") String id, @RequestParam(name = "bookName") String updatedBookName) {
		return bookService.updateBookNameById(id, updatedBookName);
	}

	@PostMapping("/book")
	String createBook(@RequestParam(name = "id") String id) {
		return bookService.createBook(id);
	}

	@DeleteMapping("/book")
	String deleteBook(@RequestParam(name = "id") String id) {
		return bookService.deleteBook(id);
	}

	@GetMapping("/book/total-pages")
	Integer bookTotalPages(@RequestParam(name = "id") String id) {
		return bookService.bookTotalPages(id);
	}

	@GetMapping("/company/name")
	String getCompanyName() {
		return companyService.getCompanyName();
	}

	@GetMapping("/user/name")
	String getUserName() {
		return userService.getUserName();
	}

	@GetMapping("/user-name-in-current-lang")
	String getUserNameInCurrentLang() {
		return userService.getUserNameInCurrentLang();
	}

}
