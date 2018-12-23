package com.company._6_transform;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 把数据转成JSON
 * @author yonghui
 *
 */
public class EmployeeTest {
	
	@Test
	public void testJson() throws Exception {
		Department dept = new Department(1L,"dname");
		Employee emp = new Employee(1L,"ename",dept);
		Object obj = emp.toJson();
		System.out.println(obj);
		System.out.println(JSON.toJSONString(obj));
	}
}
