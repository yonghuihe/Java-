package com._520it.shop.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shop.dao.IProductDAO;
import com._520it.shop.dao.impl.ProductDAOImpl;
import com._520it.shop.domain.Product;
import com._520it.shop.util.StringUtil;

//处理商品对象的CRUD操作
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductDAO dao = new ProductDAOImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//做登录检查
		Object user = req.getSession().getAttribute("user_in_session");
		if (user==null) {//如果没有登录,跳转到登录页面
			resp.sendRedirect("/login.jsp");
			return;
		}
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			save(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else if ("edit".equals(cmd)) {
			edit(req, resp);
		} else {
			list(req, resp);
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:获取请求参数
		Long id = Long.parseLong(req.getParameter("id"));
		//2:调用业务方法处理请求
		dao.delete(id);
		//3:控制界面跳转
		resp.sendRedirect("/product");
	}

	private void save(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:获取请求参数
		String productName = req.getParameter("productName");
		String salePrice = req.getParameter("salePrice");
		String dir_id = req.getParameter("dir_id");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		Product product = new Product(null, productName, new BigDecimal(salePrice), Long.parseLong(dir_id), 
				supplier, brand, Double.parseDouble(cutoff),  new BigDecimal(costPrice));
		String id = req.getParameter("id");
		//2:调用业务方法处理请求
		if (StringUtil.hasLength(id)) {
			//有id,做更新操作
			product.setId(Long.parseLong(id));
			dao.update(product);
		} else {
			//没有id,做新增操作
			dao.save(product);
		}
		//3:控制界面跳转
		resp.sendRedirect("/product");
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:获取请求参数
		String id = req.getParameter("id");
		//2:调用业务方法处理请求
		if (StringUtil.hasLength(id)) {
			Product product = dao.get(Long.parseLong(id));
			req.setAttribute("product", product);
		}
		//3:控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数
		//2:调用业务方法处理请求
		List<Product> list = dao.list();
		//3:控制界面跳转
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
}
