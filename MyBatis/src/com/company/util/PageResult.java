package com.company.util;

import java.util.List;

import com.company.domain.Employee;

public class PageResult {

	private Long total;
	private List<Employee> rows;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<Employee> getRows() {
		return rows;
	}

	public void setRows(List<Employee> rows) {
		this.rows = rows;
	}

	public PageResult(Long total, List<Employee> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

}
