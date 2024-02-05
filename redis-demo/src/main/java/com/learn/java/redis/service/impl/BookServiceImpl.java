package com.learn.java.redis.service.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Cacheable(value = {"book444", "Book44"}, key = "#id")
	@Override
	public String getBookById(String id) {
		try {
			System.out.println("Before Sleep");
			Thread.sleep(1000);
			System.out.println("After Sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "bookName";

	}

}