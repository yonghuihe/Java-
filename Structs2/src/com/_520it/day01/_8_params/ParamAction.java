package com._520it.day01._8_params;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class ParamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Setter
	private String username;
	@Setter
	private String age;
	
	public String execute() throws Exception {
		System.out.println(username);
		System.out.println(age);
		//System.out.println("ParamAction.execute()");
		return NONE;
	}
}
