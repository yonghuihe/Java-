package com.company.springboot.springjavaconfig._07ValueInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * 引入单个文件：@PropertySource
 * 
 * @author yonghui
 *
 */
@Configuration
@PropertySource("classpath:com/company/springboot/javaconfig/_07ValueInject/db.properties")
public class AppConfig {

	/**
	 * 方式二：注入Environment，在注入的bean中通过：environment.getProperty("配置文件中的key")获取
	 * 缺陷，返回的String类型
	 */
	@Autowired
	private Environment environment;

	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;

	@Bean
	public DateSource datesource() {
		String username = environment.getProperty("db.username");
		String password = environment.getProperty("db.password");
		String url = environment.getProperty("db.url");
		return new DateSource(username, password, url);
	}

	/**
	 * 方式一：注入PropertySourcesPlaceholderConfigurer，使用static修饰，提高优先级 
	 * 	优势，自动注入，使用的较多
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
