package com.company.springboot.springjavaconfig._05Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={RedisConfig.class,DateSourceConfig.class})
public class AppConfig {

}
