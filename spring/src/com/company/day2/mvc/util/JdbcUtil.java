package com.company.day2.mvc.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class JdbcUtil {
	
	@PostConstruct
	private void init() {
		System.out.println("初始化DataSource");
	}
	
	public void getConnection(){
		System.out.println("获取数据库连接");
	}
	
	@PreDestroy
	private void destory(){
		System.out.println("销毁连接");
	}
}
