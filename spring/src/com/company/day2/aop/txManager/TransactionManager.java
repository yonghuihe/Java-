package com.company.day2.aop.txManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManager {
	/**
	 * 声明一个pointcut <aop:pointcut expression=
	 * "execution(* com.company.day2.aop.service.*Service.*(..))" id="pc"/>
	 */
	@Pointcut("execution(* com.company.day2.aop.service.*Service.*(..))")
	public void pc() {
	}

	@Before(value = "pc()")
	public void begin() {
		System.out.println("开启事务");
	}

	/**
	 * 在方法正常执行之后
	 */
	@AfterReturning(value = "pc()")
	public void commit() {
		System.out.println("提交事务");
	}

	/**
	 * 在抛出异常的时候，如果要得到抛出的异常
	 * 	1、在方法中添加一个参数，起一个参数名字
	 * 	2、在<aop:after-throwing>中添加一个throwing属性，属性的名字就是这个方法的参数的名字
	 * @param ex
	 */
	@AfterThrowing(pointcut="pc()",throwing="ex")
	public void AfterThrowing(Throwable ex) {
		System.out.println("回滚事务"+ex.getMessage());
	}
	
	/**
	 * 在方法执行之后
	 * 相当于finally里面
	 */
	@After("pc()")
	public void after() {
		System.out.println("after");
	}

	@Around("pc()")
	public Object around(ProceedingJoinPoint pjp) {
		try {
			System.out.println("begin");
			Object ret = pjp.proceed();
			System.out.println("commit");
			return ret;
		} catch (Throwable e) {
			System.out.println("rollback");
		} finally {
			System.out.println("after");
		}
		return null;
	}
}
