package com.company._3_login;

import com.company.BaseAction;
import com.company.ResultClass;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public String execute() throws Exception {
		// 模拟登录成功
		ResultClass result = null;
		if ("admin".equals(username) && "123".equals(password)) {
			result = new ResultClass(true, "登录成功");
		} else {
			result = new ResultClass(false, "账号和密码不匹配");
		}
		writeJsonString(result);
		return NONE;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
