package com.company.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.company.domain.Employee;
import com.company.mapper.EmployeeMapper;
import com.company.query.EmployeeQueryObject;
import com.company.service.IEmployeeService;
import com.company.util.MyBatisUtil;
import com.company.util.PageResult;

@SuppressWarnings("all")
public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeMapper employeeMapper;
	
	@Override
	public PageResult getPageResult(EmployeeQueryObject qo) {
		SqlSession session = MyBatisUtil.openSession();
		//通过session来获取mapper接口的实例
		employeeMapper = session.getMapper(EmployeeMapper.class);
		
		//查询结果总数
		Long count = employeeMapper.selectPageResultCount(qo);
		if(count > 1){
			//查询结果集
			List<Employee> list = employeeMapper.selectPageResult(qo);
			return new PageResult(count, list);
		}
		return new PageResult(count, Collections.EMPTY_LIST);
	}

}
