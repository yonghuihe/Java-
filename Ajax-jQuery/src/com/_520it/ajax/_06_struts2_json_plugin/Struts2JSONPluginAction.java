package com._520it.ajax._06_struts2_json_plugin;

import java.util.List;
import com._520it.ajax._04_linkage.Province;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//演示Struts2的JSON插件的使用
public class Struts2JSONPluginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Province> ps;
	//属性:ps
	public List<Province> getPs(){
		return ps;
	}
	//属性:username
	public String getUsername(){
		return "张三丰";
	}
	public String execute() throws Exception {
		ps = Province.getProvinces();
		//把数据共享到context区域
		ActionContext.getContext().put("provinces", Province.getProvinces());
		return SUCCESS;
	}
}