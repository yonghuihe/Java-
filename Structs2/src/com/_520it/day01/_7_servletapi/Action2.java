package com._520it.day01._7_servletapi;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Action2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		String username = req.getParameter("username");
		System.out.println(username);
		return NONE;
	}	
}
