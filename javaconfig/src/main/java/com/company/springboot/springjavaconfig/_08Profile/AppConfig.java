package com.company.springboot.springjavaconfig._08Profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @Import了多个配置文件，但是不会对引入的配置文件都进行初始化
 * 
 * @author yonghui
 *
 */
@Configuration
@Import(value = { DevConfig.class, TestConfig.class })
public class AppConfig {

	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;

	@Bean
	public DateSource datesource() {
		return new DateSource(username, password, url);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
