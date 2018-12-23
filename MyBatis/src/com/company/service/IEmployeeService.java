package com.company.service;

import com.company.query.EmployeeQueryObject;
import com.company.util.PageResult;

public interface IEmployeeService {
	public PageResult getPageResult(EmployeeQueryObject qo);
}
