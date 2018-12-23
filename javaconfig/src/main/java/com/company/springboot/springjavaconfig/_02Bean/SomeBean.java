package com.company.springboot.springjavaconfig._02Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SomeBean {

	@PostConstruct
	public void init(){
		System.out.println("====init===");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("====destroy===");
	}
}
