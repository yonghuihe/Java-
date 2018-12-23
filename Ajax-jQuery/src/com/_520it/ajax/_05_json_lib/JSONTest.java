package com._520it.ajax._05_json_lib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com._520it.ajax._04_linkage.Province;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {
	@Test
	public void testFastJson() throws Exception {
		//单个对象(JavaBean)-->JSON字符串
		Province p = new Province(13L,"四川省");
		String jsonString = JSON.toJSONString(p);
		System.out.println(jsonString);
		//单个对象(Map)-->JSON字符串
		Map<String, Object> map = new HashMap<>();
		map.put("id", 123L);
		map.put("name", "四川省");
		System.out.println(JSON.toJSONString(map));
		//---------------------------------
		//多个对象:List<Province>--JSON字符串
		List<Province> ps = Province.getProvinces();
		System.out.println(ps);
//		System.out.println(JSON.toJSONString(ps,true));
	}
	@Test
	public void testJackJson() throws Exception {
		//单个对象(JavaBean)-->JSON字符串
		Province p = new Province(13L,"四川省");
		String jsonString = new ObjectMapper().writeValueAsString(p);
		System.out.println(jsonString);
		//单个对象(Map)-->JSON字符串
		Map<String, Object> map = new HashMap<>();
		map.put("id", 123L);
		map.put("name", "四川省");
		System.out.println(new ObjectMapper().writeValueAsString(map));
		//---------------------------------
		//多个对象:List<Province>--JSON字符串
		List<Province> ps = Province.getProvinces();
		System.out.println(ps);
		System.out.println(new ObjectMapper().writeValueAsString(ps));
	}
}
