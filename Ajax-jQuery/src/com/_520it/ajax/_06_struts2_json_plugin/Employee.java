package com._520it.ajax._06_struts2_json_plugin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Employee implements IJsonObject{
	private Long id = 123L;
	private String name = "will";
	private int age = 17;
	private String password = "1";
	private Date hireDate = new Date();

	public Object toJson() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("age", age);
		return map;
	}
	public static void main(String[] args) {
		Employee e = new Employee();
		System.out.println(JSON.toJSONString(e));
		
		System.out.println(JSON.toJSONString(e.toJson()));
	}
	// 需求:想把Employee中id,name,age,转换为JSON字符串
}
