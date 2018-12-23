package com._520it.day01._8_params;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ParamAction3 extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private User u = new User();
	public String execute() throws Exception {
		System.out.println(u);
		//System.out.println(age);
		//System.out.println("ParamAction.execute()");
		return NONE;
	}
	@Override
	public User getModel() {
		return u;
	}
}
