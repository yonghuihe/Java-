package com.company.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 直接实现Controller接口的方式，需要覆盖handleRequest方法
 * @author yonghui
 *
 */
public class HelloWordController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("msg", "hellow springMVC");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
		return null;
	}

}
