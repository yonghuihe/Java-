package com.company.springboot.springjavaconfig._03Inject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SomeBean {
	private OtherBean otherbean;
}
