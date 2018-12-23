package com._520it.day02._05_tag;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class TagAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Setter@Getter
	private String username;
	
	public String execute() throws Exception {
		System.out.println(username);
		Map<Object,Object> map = new HashMap<>();
		map.put("1", "男");
		map.put("2", "女");
		ActionContext.getContext().put("genders", map);
		
		//把数据存入context中
		/*ActionContext.getContext().put("num", 123);
		User u1 = new User(10L, "蜡笔小新", new BigDecimal("999"));
		User u2 = new User(20L, "小黄人", new BigDecimal("998"));
		List<User> list = Arrays.asList(u1,u2);
		ActionContext.getContext().put("list", list);*/
		return SUCCESS;
	}
}
