package com.company.springboot.springjavaconfig._05Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate redisTemplate(){
		return new RedisTemplate();
	}
}
