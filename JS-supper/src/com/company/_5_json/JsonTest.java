package com.company._5_json;

import com.company._link.Province;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JsonTest extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String username = "逍遥";
	
	private String password = "123";
	
	private int age = 18;
	
	public String execute() throws Exception {
		ActionContext.getContext().put("ps", Province.getProvinces());
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	//@JSON(serialize=false)
	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}
	
	

}
