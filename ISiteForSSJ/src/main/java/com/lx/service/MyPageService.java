package com.lx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.lx.repositroy.MyPageDao;

public class MyPageService {

	@Autowired
	private MyPageDao myPageDao;
	
	@Autowired
	private Pageable pageable;
	
	
	private int pageSize = 8;

	private String requestPage;

	private int recordCount = -1;

	private int firstRow = 0;

	private int rowCount = 10;

	
	private int currentPage = 1;

	private int pageCount = 1;

	private int firstPage = 1;

	private int priviousPage = 1;

	private int nextPage = 1;

	private int lastPage = 1;

	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		pageable.getPageSize();
		this.pageSize = pageSize;
	}

	public String getRequestPage() {
//		pageable.
		
		return requestPage;
	}

	public void setRequestPage(String requestPage) {
		this.requestPage = requestPage;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPriviousPage() {
		return priviousPage;
	}

	public void setPriviousPage(int priviousPage) {
		this.priviousPage = priviousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	
	
	
	
}
