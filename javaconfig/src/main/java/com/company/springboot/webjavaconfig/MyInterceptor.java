package com.company.springboot.webjavaconfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=======javaconfig 拦截器========");
		System.out.println(request.getRequestURL());
		return super.preHandle(request, response, handler);
	}

	
}
