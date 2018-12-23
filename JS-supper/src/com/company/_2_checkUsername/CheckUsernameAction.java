package com.company._2_checkUsername;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUsernameAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<String> users = Arrays.asList("admin", "test");

	private String username;

	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		/*if (users.contains(username)) {
			response.getWriter().println(username + "已存在");
		} else {
			response.getWriter().println(username + "可以注册");
		}*/
		//把返回的结果封装成JSON
		Map<String,Object> map = new HashMap<String, Object>(){};
		if (users.contains(username)) {
			map.put("success", false);
			map.put("msg", username + "已经注册过了");
		} else {
			map.put("success", true);
			map.put("msg", username + "可以注册");
		}
		response.getWriter().println(JSON.toJSONString(map));
		return NONE;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
