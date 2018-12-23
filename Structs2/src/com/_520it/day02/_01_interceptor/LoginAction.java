package com._520it.day02._01_interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Setter
	private String username;
	@Setter
	private String password;
	
	public String execute() throws Exception {
		//模拟登录
		if ("root".equals(username) && "1234".equals(password)) {
			ActionContext.getContext().getSession().put("user_in_session", username);//将当前登录成功的信息放到session中
			return SUCCESS;
			
		}
		return NONE;
	}
}
