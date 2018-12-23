package com._520it.day01._6_method;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//list
	public String execute() throws Exception {
		System.out.println("查询员工列表");
		return NONE;
	}
	//savaOrUpdate
	public String savaOrUpdate() throws Exception {
		System.out.println("保存或修改员工信息");
		return NONE;
	}
	//edit
	public String edit() throws Exception {
		System.out.println("编辑员工列表");
		return NONE;
	}
	//delete
	public String delete() throws Exception {
		System.out.println("删除员工列表");
		return NONE;
	}
}
