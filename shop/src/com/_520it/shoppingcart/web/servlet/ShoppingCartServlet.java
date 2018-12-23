package com._520it.shoppingcart.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shoppingcart.dao.ShoppingCart;
import com._520it.shoppingcart.domain.CarItem;

@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取ID,num
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		//从session中取出购物车
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart_in_session");
		if (cart==null) {//第一次访问没有购物车,创建一个在放进session中
			cart = new ShoppingCart();
			req.getSession().setAttribute("cart_in_session", cart);
		}
		//专门处理删除操作
		String cmd = req.getParameter("cmd");
		if ("delete".equals(cmd)) {
			cart.removeItem(Long.parseLong(id));//调用ShoppingCart中的删除方法,删除指定的ID中所有的元素
			req.getRequestDispatcher("/WEB-INF/views/shop/list.jsp").forward(req, resp);
			return;
		}
		CarItem item = null;
		if ("1".equals(id)) {
			item = new CarItem(Long.parseLong(id),"苹果表",new BigDecimal("2000"),Integer.parseInt(num));
		}else if ("2".equals(id)) {
			item = new CarItem(Long.parseLong(id),"外星人",new BigDecimal("4000"),Integer.parseInt(num));
		}else{
			item = new CarItem(Long.parseLong(id),"mac pro",new BigDecimal("6000"),Integer.parseInt(num));
		}
		cart.addItem(item);
		req.getRequestDispatcher("/WEB-INF/views/shop/list.jsp").forward(req, resp);
	}
}	
