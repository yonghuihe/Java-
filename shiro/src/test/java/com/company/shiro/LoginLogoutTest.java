package com.company.shiro;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class LoginLogoutTest {

	@Test
	public void test() {
		//1、创建SecurityManager工厂
		IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、根据SecurityManager工厂创建SecurityManager实例
		SecurityManager securityManager = securityManagerFactory.getInstance();
		//3、将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//4、创建一个Subject实例
		Subject subject = SecurityUtils.getSubject();
		//5、创建token令牌
		UsernamePasswordToken token = new UsernamePasswordToken("root", "admin");
		//6、登录
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			System.out.println("账户找不到");
		}catch (IncorrectCredentialsException e) {
			System.out.println("凭证错误");
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("是否认证："+subject.isAuthenticated());
		
		//角色测试：
		//判断用户是否拥有某个角色
		System.out.println(subject.hasRole("role1"));
		System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2")));
		
		//权限测试：
		//判断用户是否拥有某个权限
		System.out.println(subject.isPermitted("user:create"));
		System.out.println(subject.isPermittedAll("user:create","user:delete"));
		
		//7、注销
		subject.logout();
		System.out.println("注销");
	}

}
