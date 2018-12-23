package com.company.springboot.springjavaconfig._06ImportResource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * xml与javaconfig配置同时存在，使用@ImportResource
 * @author yonghui
 *
 */
@Configuration
@ImportResource(value="com/company/springboot/javaconfig/_06ImportResource/applicationContext.xml")
public class AppConfig {
	
	@Bean
	public SomeBean someBean(){
		return new SomeBean();
	}
}
