package com._520it.oa.web.action;

import javax.servlet.http.HttpServletRequest;

import com._520it.core.web.ActionContext;

//处理Employee相关请求
public class EmployeeAction {
	private String username;
	
	public void excute() {
		System.out.println("员工列表");
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = context.getRequest();
		username = request.getParameter("username");
		System.out.println(username);
	}
}
