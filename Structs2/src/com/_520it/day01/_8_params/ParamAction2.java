package com._520it.day01._8_params;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

public class ParamAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Getter
	private User u = new User();
	public String execute() throws Exception {
		System.out.println(u);
		//System.out.println(age);
		//System.out.println("ParamAction.execute()");
		return NONE;
	}
}
