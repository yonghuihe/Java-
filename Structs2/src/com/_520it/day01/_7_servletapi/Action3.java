package com._520it.day01._7_servletapi;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Action3 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
//		String username = req.getParameter("username");
		//通过ActionContext工具类来获取
		ActionContext context = ActionContext.getContext();
		Map<String, Object> applicationMap = context.getApplication();
		Map<String, Object> sessionMap = context.getSession();
		Map<String, Object> map = context.getParameters();
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			String[] value = (String[]) entry.getValue();
			System.out.println(Arrays.toString(value));
		}
		//===================================================
		//req.setAttribute("xx",1);
		session.setAttribute("oo", "xx");
		sessionMap.put("username", "will");
		context.put("username", "bunny");
		applicationMap.put("username", "stef");
		return SUCCESS;
	}	
}
