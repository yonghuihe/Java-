package com.company.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.company.domain.User;

/**
 * 1、使用注解的方式，
 * 		自定义方法,在方法上贴标签RequestMapping("url路径")
 * 		在配置文件中将该类交由spring管理，不用指定name属性，这种方式不是全注解
 * 	注意：在同一个类中，RequestMapping中的url路径是不能重复的
 * 	环形请求：形参需要HttpServletRequest request, HttpServletResponse response
 * 2.使用全注解的方式：
 * 	
 * @author yonghui
 *
 */
@SuppressWarnings("all")
@Controller
//@RequestMapping("/springMVC")
public class MyController{
	
	/**
	 * 处理日期-前台往后台传递日期参数
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
	}

	/**
	 * 通过请求对象来传参：request.setAttribute("msg","参数");
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("msg", "index");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
		return null;
	}
	/**
	 * 使用ModelAndView的方式来传参 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index1")
	public ModelAndView index1() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","modelAndView");//key-value方式
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "jack");
		map.put("password", "password");
		modelAndView.addAllObjects(map);//通过map集合的方式
		
		//不需要使用到InternalResourceViewResolver视图解析器的时候可以在路径前加redirect、forward
		modelAndView.setViewName("forward:/WEB-INF/view/index.jsp");
		
		return modelAndView;
	}
	/**
	 * 直接返回一个对象，配置视图解析器，视图结果为：前缀+url路径+后缀
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/param")
	public User index2(){
		User user = new User();
		user.setUsername("jack");
		user.setPassword("password");
		return user;
	}

	@RequestMapping("/employee")
	public String index3(Model model){
		model.addAttribute("msg","员工");
		return "emp";
	}
	
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request, HttpServletResponse response) {
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("--------");
		request.setAttribute("msg", "test2");
		request.getRequestDispatcher("/test2.html").forward(request, response);
		return null;
	}
	
	/**
	 * 同名匹配的方式来传参
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping("/login")
	public ModelAndView test3(String username,String password) throws Exception {
		
		System.out.println(username);
		System.out.println(password);
		
		return null;
	}
	
	/**
	 * 使用原生的方式来传参
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping("/login")
	public ModelAndView test4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		return null;
	}
	
	/**
	 * 使用对象来传参
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView test5(User user) throws Exception {
		System.out.println(user.getInputTime().toLocaleString());
		
		return null;
	}
	
	/**
	 * 使用restful风格来传参
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView test6(@PathVariable("id")Long id) throws Exception {
		System.out.println(id);
		return null;
	}

	//@RequestMapping("/login")
	//@ResponseBody//我们期望返回给前台的是json数据，所以加上这个标签
	public AjaxResult test6(User user) throws Exception {
		
		AjaxResult result = new AjaxResult();
		result.setSuccess("true");
		result.setMsg("登录成功");
		result.setInputTime(new Date());
		
		return result;
	}
	
	/**
	 * 文件上传
	 * @param user
	 * @param file
	 * @throws IOException
	 */
	//@RequestMapping("/login")
	public void upload(User user,@RequestParam(value = "img", required = false)MultipartFile file) throws IOException{
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		OutputStream out = new FileOutputStream(new File("D:/cc.png"));	
		IOUtils.copy(file.getInputStream(), out);
		out.close();
	}
	

}
