package com.learn.java.rest.model;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;

public class Pager implements Pageable, Serializable {

	private static final long serialVersionUID = -5529333118243515095L;

	private Integer pageNumber;
	private Integer pageSize;
	private long offset;
	private Integer totalPages;

	public Pager() {
		super();
	}

	public Pager(Integer pageNumber, Integer pageSize, long offset, Integer totalPages) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.offset = offset;
		this.totalPages = totalPages;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public long getOffset() {
		return offset;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public org.springframework.data.domain.Sort getSort() {
		return null;
	}

	@Override
	public Pageable next() {
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		return null;
	}

	@Override
	public Pageable first() {
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public Pageable withPage(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
