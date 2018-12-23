package com.company.springboot.webjavaconfig;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * 替换applicationContext_web.xml
 * 
 * @author yonghui
 *
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer cfg = new FreeMarkerConfigurer();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateLoaderPath("/WEB-INF/views/");
		return cfg;
	}

	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver vr = new FreeMarkerViewResolver();
		vr.setExposeSessionAttributes(true);
		vr.setSuffix(".ftl");
		vr.setContentType("text/html;charset=UTF-8");
		return vr;
	}

	// 配置CompanyHandlerMethodArgumentResolver
	@Bean
	public CompanyHandlerMethodArgumentResolver companyHandlerMethodArgumentResolver() {
		return new CompanyHandlerMethodArgumentResolver();
	}

	// 向springmvc中注册CompanyHandlerMethodArgumentResolver
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(companyHandlerMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}

	// 配置拦截器
	@Bean
	public MyInterceptor myInterceptor() {
		return new MyInterceptor();
	}

	// 往springMVC中注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor()).excludePathPatterns("hello");
		super.addInterceptors(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/view1").setViewName("/view1");
		super.addViewControllers(registry);
	}

}
