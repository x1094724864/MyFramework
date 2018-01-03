package com.lx.vo;

import java.io.Serializable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Pages extends PageRequest implements Serializable {

	public Pages(int pageNumber, int pageSize) {
		super(pageNumber, pageSize);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6137662753444932476L;

	private int pageNumber;				// 总页码
	private int pageSize=5;				// 页面尺寸
	private int offset;					// 每页第一条数据（偏移量）
	private int pageRequest;			// 请求页面
	private Sort sort;					// 排序
	private Pageable next;				// 下一页
	private Pageable previousOrFirst;	// 上一页 或者首页
	private Pageable first;				// 首页
	private boolean hasPrevious;		// 是否有上一页

	private int currentPage = 1;
	private int recordCount = -1;
	private int priviousPage = 1;
	private int nextPage = 1;
	private int lastPage = 1;
	// private int pageSize = 8;
	// private String requestPage;
	// private int firstRow = 0;
	// private int rowCount = 10;
	// private int pageCount = 1;
	// private int firstPage = 1;
	
	
	public void init(int recordCount, int pageSize, String requestPage) {

		if(requestPage == null){
			requestPage = "-1";
		}
		int iRequestPage = Integer.parseInt(requestPage); 		
		this.recordCount = recordCount;
		this.pageSize = pageSize;

		this.pageNumber = recordCount % pageSize == 0 ? recordCount/pageSize : recordCount/pageSize + 1;
		if (iRequestPage > this.pageNumber) {
			iRequestPage = this.pageNumber;
		} else if (iRequestPage < 1) {
			iRequestPage = 1;
		}

		this.currentPage = iRequestPage;
		this.priviousPage = this.currentPage - 1;
		this.nextPage = this.currentPage + 1;
		this.lastPage = this.pageNumber;
		this.offset = new Integer(pageSize * (this.currentPage - 1));

	}


}
