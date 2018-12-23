package com.company.springboot.springjavaconfig._01HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration标签 把一个类标记为spring的配置对象
 * 
 * @author yonghui
 *
 */
@Configuration
public class Config {
	
	@Bean
	public SomeBean someBean(){
		return new SomeBean();
	}
}
