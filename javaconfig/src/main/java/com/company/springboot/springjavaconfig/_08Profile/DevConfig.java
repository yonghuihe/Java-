package com.company.springboot.springjavaconfig._08Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:com/company/springboot/javaconfig/_08Profile/db-dev.properties")
@Profile("dev")
public class DevConfig {

	@Bean
	public SomeBean somebean(){
		return new SomeBean();
	}
}
