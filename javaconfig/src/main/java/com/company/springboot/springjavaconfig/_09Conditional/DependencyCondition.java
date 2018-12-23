package com.company.springboot.springjavaconfig._09Conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DependencyCondition implements Condition {

	/**
	 * 如果返回false，则bean不会被spring实例化
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getBeanFactory().getBeansOfType(DependencyBean.class).size() > 0;
	}

}
