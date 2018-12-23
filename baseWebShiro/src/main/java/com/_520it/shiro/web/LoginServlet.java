package com._520it.shiro.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取shiro输出的错误信息
		Object failure = req.getAttribute("shiroLoginFailure");
		System.out.println(failure);
		//如果是.UnknownAccountException就输出用户名不存在
		if(failure!=null){
				if(failure.equals(UnknownAccountException.class.getName())){
					req.setAttribute("errorMsg","用户名不存在!");
				}else if(failure.equals(IncorrectCredentialsException.class.getName())){
					req.setAttribute("errorMsg","密码错误!");
				}
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		
	}
	
}
