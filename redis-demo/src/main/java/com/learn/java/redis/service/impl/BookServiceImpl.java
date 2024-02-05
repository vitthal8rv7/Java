package com.learn.java.redis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learn.java.redis.service.BookService;

@Service
public class BookServiceImpl implements BookService {

//	@Autowired 
//	private BookRepository bookRepository;
	
	//@Cacheable("book")
	//@Cacheable(value = {"book"})
	@Cacheable(value = {"book", "Book2"})
	@Override
	public List<String> getAllBooks() {
		
		try {
			System.out.println("Before Sleep");
			Thread.sleep(1000);
			System.out.println("After Sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> resultList = new ArrayList<>();
		resultList.add("Book1");
		resultList.add("Book2");
		resultList.add("Book3");
		return resultList;
		//return bookRepository.findAll();
	}

	@Cacheable(value = {"getBookById", "getBookNameById"}, key = "#id")
	@Override
	public String getBookById(String id) {
		System.out.println("In Get getBookById Method.");
		return "bookName";

	}

	//cache it if unless returns false; don`t cache if unless returns true;
	@Cacheable(value = "bookTotalPages", key = "#id", unless = "#result < 1000")
	@Override
	public Integer bookTotalPages(String id) {
		System.out.println("In Get bookTotalPages Method.");
		Integer result = 123;
		return result;
	}

	@CachePut(value = {"getBookById", "getBookNameById"}, key = "#id")
	@Override
	public String updateBookNameById(String id, String updatedBookName) {
		System.out.println("In Get updateBookNameById Method.");
		return updatedBookName;
	}

	@CachePut(value = {"getBookById", "getBookNameById"}, key = "#id")
	@Override
	public String createBook(String id) {
		System.out.println("In Get createBook Method.");
		return "BookVitthal1234";
	}

	@CacheEvict(value = {"getBookById", "getBookNameById"}, key = "#id")
	@Override
	public String deleteBook(String id) {
		System.out.println("In Get deleteBook Method.");
		return "cache evicted.";
	}
	
	

}
