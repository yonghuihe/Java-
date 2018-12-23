package com._520it.core.web.config;

public class ActionConfig {
	private String name;
	private String className;
	private String method;

	public ActionConfig() {
		super();
	}

	public ActionConfig(String name, String className, String method) {
		this.name = name;
		this.className = className;
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "ActionConfig [name=" + name + ", className=" + className + ", method=" + method + "]";
	}
}
