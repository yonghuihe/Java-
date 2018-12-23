package com._520it.day01._7_servletapi;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Action1 extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	
	public String execute() throws Exception {
		System.out.println(req.getParameter("username"));
		return NONE;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.req = request;
	}
}
