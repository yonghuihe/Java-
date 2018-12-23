package com._520it.from;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/money")
public class MoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String token = req.getParameter("token");
		Object tokenInSession = req.getSession().getAttribute("token_in_session");
		req.getSession().removeAttribute("token_in_session");
		if (token.equals(tokenInSession)) {
			resp.getWriter().println("手贱");
			return;
		}
		String money = req.getParameter("money");
		System.out.println("转出:"+money);
		resp.getWriter().println("转出:"+money);
	}
}
