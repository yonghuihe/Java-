package com.company.springboot.springjavaconfig._08Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:com/company/springboot/javaconfig/_08Profile/db-test.properties")
@Profile("test")
public class TestConfig {

	@Bean
	public OtherBean otherbean(){
		return new OtherBean();
	}
}
