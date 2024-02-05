package com.learn.java.redis.service;

import java.util.List;

public interface BookService {

	public List<String> getAllBooks();

	public String getBookById(String id);

	public Integer bookTotalPages(String id);

	public String updateBookNameById(String id, String updatedBookName);

}
