package com.company.springboot.springjavaconfig._03Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Configuration标签 把一个类标记为spring的配置对象
 * 
 * @author yonghui
 *
 */
@Configuration
public class Config {

	/**
	 * 方式二，现在spring容器中注入OtherBean，作为参数直接注入到SomeBean中
	 * 	如果找到多个类型相同的
	 * 		1、使用@Qualifier
	 * 		2、
	 * @param otherbean
	 * @return @Primary
	 */
	@Bean
	public SomeBean somebean3(@Qualifier("otherBean") OtherBean otherbean) {
		SomeBean someBean = new SomeBean();
		someBean.setOtherbean(otherbean);
		return someBean;
	}

	/**
	 * 方式一：内部bean，没有id，没有办法让其他的bean使用
	 * 
	 * @return
	 */
	@Bean
	public SomeBean somebean1() {
		SomeBean someBean = new SomeBean();
		someBean.setOtherbean(new OtherBean());
		return someBean;
	}

	@Bean
	public SomeBean somebean2() {
		SomeBean someBean = new SomeBean();
		someBean.setOtherbean(otherBean());
		return someBean;
	}

	// 注册
	@Bean
	public OtherBean otherBean() {
		return new OtherBean();
	}

	@Bean
	@Primary
	public OtherBean otherBean2() {
		return new OtherBean();
	}
}
