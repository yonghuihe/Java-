package com._520it.day02._01_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import lombok.Setter;

//自定义拦截器
public class CheckLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Setter
	private String scopeName;
	@Setter
	private String loginView;
	//执行拦截的方法
	public String intercept(ActionInvocation invocation) throws Exception {
		Object obj = invocation.getInvocationContext().getSession().get(scopeName);
		if (obj == null) {//没有登录返回逻辑视图的名称,完成跳转
			return loginView;
		}
		//已经登录
		return invocation.invoke();
	}

}
