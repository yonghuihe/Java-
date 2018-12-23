package com._520it.day02._04_valueStack;

import java.util.Arrays;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import lombok.Getter;

public class ValueStackAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Getter
	private String name = "荆轲刺秦王";
	public String execute() throws Exception {
		/*//获取值栈对象的方式1
		Object obj = ServletActionContext.getRequest().getAttribute("struts.valueStack");
		System.out.println(obj);
		obj = ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(obj);
		//获取值栈对象的方式2*/
		
		//获取值栈中的的数据
		ValueStack vs = ActionContext.getContext().getValueStack();

		//把数据放入root区域
		/*vs.getRoot().push("荆轲刺秦王");
		System.out.println(vs);
		vs.set("name", "荆轲刺秦王");
		System.out.println(vs);*/
		
		//把数据存入context区域
		vs.getContext().put("age", 18);
		vs.getContext().put("list", Arrays.asList(1,2,3));
		ActionContext.getContext().put("list", Arrays.asList(1,2,3));
		return SUCCESS;
	}
}
