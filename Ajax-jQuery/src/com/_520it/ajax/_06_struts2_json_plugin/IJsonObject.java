package com._520it.ajax._06_struts2_json_plugin;

public interface IJsonObject {
	//返回需要转换的json的对象,一般是Map<String, Object>
	Object toJson();
}
