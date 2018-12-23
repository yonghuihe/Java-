package com.company.springboot.springjavaconfig._02Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration标签 把一个类标记为spring的配置对象
 * 
 * @author yonghui
 *
 */
@Configuration
public class Config {
	
	@Bean
	public SomeBeanFactory somebean(){
		return new SomeBeanFactory();
		
	}

	/**
	 * 方法名-->bean id name-->bean id，可以配置多个 
	 * 
	 * initMethod-->对应SomeBean中init方法
	 * destroyMethod-->对应SomeBean中destroy方法（junit没有正常关闭spring，所以不会执行，使用AnnotationConfigApplicationContext,ctx.close();）
	 * 可以使用标签@PostConstruct、@PreDestroy执行init、destroy方法
	 * 
	 * @return
	 */
	@Bean(name = { "someBean", "someBean2" }
	// ,initMethod = "init", destroyMethod = "destroy"
	)
	public SomeBean someBean() {
		return new SomeBean();
	}
}
