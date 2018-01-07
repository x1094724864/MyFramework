package com.lx.utils;

import java.io.Serializable;

import org.apache.commons.validator.GenericValidator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager implements Serializable {

	private static final long serialVersionUID = -4853649627933466931L;

	private int pageSize = 10;		//一页包含多少条数据
	private String requestPage;		//请求的页码
	private int recordCount = -1;	//总记录
	private int firstRow = 0;		//第一条
	private int rowCount = 10;		//行数
	private int currentPage = 1; 	//当前页
	private int pageCount = 1;		//页码数
	private int firstPage = 1;		//第一页
	private int priviousPage = 1;	//上一页
	private int nextPage = 1;		//下一页
	private int lastPage = 1;		//尾页
	
	public Pager() {
	}

	public String getRequestPage() {
		return GenericValidator.isLong(this.requestPage) ? this.requestPage : "1";
	}

	/**
	 * @param recordCount
	 * @param pageSize
	 * @param requestPage
	 */
	public void init(int recordCount, int pageSize, String requestPage) {

		if (requestPage == null) {
			requestPage = "-1";
		}
		int iRequestPage = Integer.parseInt(requestPage);
		this.recordCount = recordCount;
		this.pageSize = pageSize;

		this.pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
		if (iRequestPage > this.pageCount) {
			iRequestPage = this.pageCount;
		} else if (iRequestPage < 1) {
			iRequestPage = 1;
		}

		this.currentPage = iRequestPage;
		this.priviousPage = this.currentPage - 1;
		this.nextPage = this.currentPage + 1;
		this.lastPage = this.pageCount;
		this.firstRow = new Integer(pageSize * (this.currentPage - 1));
		this.rowCount = this.pageSize;

	}
}
