package com.company.day2.annotation;

import org.junit.Test;

public class MarkTest {
	@Test
	public void test() throws Exception {
		Class<?> c = SomeBean.class;
		if (c.isAnnotationPresent(Mark.class)) {
			System.out.println("对象上有Mark标签");
			Mark mark = c.getAnnotation(Mark.class);
			System.out.println(mark.value());
		}
	}
}
