package com.company.springboot.springjavaconfig._05Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateSourceConfig {

	@Bean
	public DateSource datesource(){
		return new DateSource();
	}
}
