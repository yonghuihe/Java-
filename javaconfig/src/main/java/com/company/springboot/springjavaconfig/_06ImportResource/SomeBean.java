package com.company.springboot.springjavaconfig._06ImportResource;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SomeBean {

	@Autowired
	private OtherBean otherBean;
}
