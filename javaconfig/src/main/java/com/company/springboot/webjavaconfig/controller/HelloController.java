package com.company.springboot.webjavaconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.springboot.webjavaconfig.Compnaykeyword;

@Controller
public class HelloController {

	/**
	 * 使用@Compnaykeyword，注入参数
	 * 
	 * @param model
	 * @param msg
	 * @return
	 */
	@RequestMapping("hello")
	public String hello(Model model, @Compnaykeyword String msg) {
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "hello";
	}

	@RequestMapping("input")
	@ResponseBody
	public String input(String value) {
		System.out.println(value);
		return "success";
	}
}
