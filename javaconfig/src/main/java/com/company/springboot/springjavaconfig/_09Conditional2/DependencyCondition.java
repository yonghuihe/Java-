package com.company.springboot.springjavaconfig._09Conditional2;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class DependencyCondition implements Condition {

	/**
	 * 如果返回false，则bean不会被spring实例化
	 * 判断当前spring上下文中是否存在IFExist标签中的value，如果存在则该bean被spring实例化
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (context.getEnvironment() != null) {
			MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(IFExist.class.getName());
			if (attrs != null) {
				for (Object value : attrs.get("value")) {
					if (context.getBeanFactory().getBeansOfType((Class)value).size() > 0) {
						return true;
					}
				}
				return false;
			}
		}
		return true;
	}

}
