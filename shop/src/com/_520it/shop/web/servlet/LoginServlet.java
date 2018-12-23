package com._520it.shop.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shop.dao.impl.UserDAOImpl;
import com._520it.shop.domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserDAOImpl dao = new UserDAOImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//检查验证码输入是否正确
		String randomCode = req.getParameter("randomCode");
		//从session中取出之前存放的验证码
		Object code = req.getSession().getAttribute("RANDOM_IN_SESSION");
		//验证码只能使用一次
		req.removeAttribute("RANDOM_IN_SESSION");
		if (randomCode.equals(code)) {//检查验证码输入是否正确
			resp.sendRedirect("/login.jsp");
			return;
		}
		//------------------------------------------
		//1.接受请求参数封装成对象
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+password);
		//2.调用业务方法处理请求
		User user = dao.checkLogin(username);
		System.out.println(user);
		if (user == null) {//用户名不存在
			req.setAttribute("errorMsg", "用户名不存在");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		if (!user.getPassword().equals(password)) {//用户名存在再判断密码--账号和密码不匹配
			req.setAttribute("errorMsg", "账号和密码不匹配");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.getSession().setAttribute("user_in_session", user);
		//登录成功--把登录成功的用户存入session中
		//3.控制页面跳转
		resp.sendRedirect("/product");//跳转到product页面
	}
}