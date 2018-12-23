package com._520it.core.web.config;
//封装<result name="" type="">资源</result>
public class ResultSet {
	private String name;
	private String type;
	private String path;
	
	
	
	public ResultSet(String name, String type, String path) {
		this.name = name;
		this.type = type;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ResultSet [name=" + name + ", type=" + type + ", path=" + path + "]";
	}
}
