package com.company.springboot.springjavaconfig._09Conditional2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Import了多个配置文件，但是不会对引入的配置文件都进行初始化
 * 
 * @author yonghui
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	@IFExist(DependencyBean.class)
	public SomeBean someBean(){
		return new SomeBean();
	}
	
	@Bean
	public DependencyBean dependencyBean(){
		return new DependencyBean();
	}
}
