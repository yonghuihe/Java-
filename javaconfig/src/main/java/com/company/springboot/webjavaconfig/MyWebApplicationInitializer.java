package com.company.springboot.webjavaconfig;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 替换web.xml
 * @author yonghui
 *
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 1、创建一个WebApplicationContext
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		ctx.setServletContext(servletContext);

		// 2、注册一个DispatcherServlet
		Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);

		// 3、注册一个Filter
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(true);
		javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncoding", encodingFilter);
		filter.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "dispatcherServlet");
	}

}
