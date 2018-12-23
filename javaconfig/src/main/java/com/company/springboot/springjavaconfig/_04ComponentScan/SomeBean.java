package com.company.springboot.springjavaconfig._04ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component("somebean")
public class SomeBean {
	
	@Autowired
	private OtherBean otherbean;
}
