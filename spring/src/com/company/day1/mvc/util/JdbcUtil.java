package com.company.day1.mvc.util;

public class JdbcUtil {
	
	private void init() {
		System.out.println("初始化DataSource");
	}
	
	public void getConnection(){
		System.out.println("获取数据库连接");
	}
}
