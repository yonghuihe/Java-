package com.company._1_ServerTime;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ServerTimeAction extends ActionSupport {
	private static final long serialVersionUID = -5480452805335296634L;

	public String execute() throws Exception {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		Date date = new Date();
		resp.getWriter().print(date.toLocaleString());
		System.out.println();
		return NONE;
	}
}
