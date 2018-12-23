package com._520it.shop.domain;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class PageResult {
	public static final PageResult EMPTY_LIST = new PageResult(1,3,Collections.EMPTY_LIST,0);
	private Integer currentPage;
	private Integer pageSize;

	private List<?> data;
	private Integer totalCount;

	private Integer prevPage;
	private Integer nextPage;
	private Integer endPage;
	
	public  PageResult(Integer currentPage, Integer pageSize, List<?> data, Integer totalCount){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.data = data;
		this.totalCount = totalCount;
		
		//计算3的参数的值
		endPage = totalCount / pageSize != 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
		prevPage = currentPage - 1 > 1 ? currentPage -1 : 1;
		nextPage = currentPage + 1 < endPage ? currentPage + 1 :endPage;
	}
}
