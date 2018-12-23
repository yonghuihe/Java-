package com.company;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = -7251548270597728297L;

	//转换为json
	protected void writeJsonString(Object obj) throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/json; charset=UTF-8");
		resp.getWriter().print(JSON.toJSONString(obj));
	}
}
