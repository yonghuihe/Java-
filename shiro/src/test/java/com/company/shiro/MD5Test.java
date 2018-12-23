package com.company.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class MD5Test {
	@Test
	public void test() throws Exception {
		Md5Hash md5Hash = new Md5Hash("admin");//直接对密码进行加密
		System.out.println(md5Hash);//21232f297a57a5a743894a0e4a801fc3
		
		Md5Hash md5Hash_salt_1 = new Md5Hash("admin", "root");//加盐，散列一次的
		System.out.println(md5Hash_salt_1);//cd92a26534dba48cd785cdcc0b3e6bd1
		
		Md5Hash md5Hash_salt_2 = new Md5Hash("111", "lucy", 2);//加盐，散列2次
		System.out.println(md5Hash_salt_2);//d75d3886108501adadb22fe0a69b33bf
		
		SimpleHash simpleHash = new SimpleHash("md5", "111", "eliot", 2);//和上面的效果一样
		System.out.println(simpleHash);//75fb1934bca2c72a040166fd7bfea931
	}
}
