package com.lx.vo;
public interface IConstant {
	/**
	 * 用户未激活
	 */
	int USER_IS_NOT_ACTIVE = 0;
	
	/**
	 * 用户未激活
	 */
	int USER_IS_ACTIVE = 1;
	
	/**
	 * 热门商品
	 */
	byte PRODUCT_IS_HOT = 1;
	
	/**
	 * 非热门商品
	 */
	byte PRODUCT_IS_NOT_HOT = 0;
	
	/**
	 * 商品未下架
	 */
	byte PRODUCT_IS_UP = 1;
	
	/**
	 * 商品已下架
	 */
	byte PRODUCT_IS_DOWN = 0;
}
