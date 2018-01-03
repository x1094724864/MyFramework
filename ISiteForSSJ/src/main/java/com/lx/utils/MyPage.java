package com.lx.utils;

import org.springframework.data.domain.PageRequest;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MyPage extends PageRequest{

	public MyPage(int page, int size) {
		super(page, size);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
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
}
