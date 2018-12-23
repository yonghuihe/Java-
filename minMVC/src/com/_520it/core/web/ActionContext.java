package com._520it.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContext {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private static ThreadLocal<ActionContext> threadLocal = new ThreadLocal<>();
	
	public ActionContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	public static ActionContext getContext() {
		return threadLocal.get();
	}
	public static void setContext(ActionContext mContext) {
		threadLocal.set(mContext);
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	
}
