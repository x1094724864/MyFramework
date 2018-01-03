package com.lx.repositroy;

import org.springframework.data.domain.Pageable;

public interface MyPageDao extends Pageable {

	int getPageNumber();
	
	int getPageSize();
	
	
	
	
}
