package com.company.day2.anndi;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SomeBean {

	@Autowired(required=false)
	@Qualifier("otherBean")
//	@Resource(name="otherBean")
	private OtherBean other;
	
	public void setOtherBean(OtherBean otherBean) {
		this.other = otherBean;
	}

	@Override
	public String toString() {
		return "SomeBean [otherBean=" + other + "]";
	}

}
