package com._520it.core.web.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com._520it.core.web.ActionContext;
import com._520it.core.web.config.ActionConfig;
import com._520it.core.web.config.ResultSet;

@SuppressWarnings("all")
public class ActionFilter implements Filter {

	Map<String, ActionConfig> actionConfigMap = new HashMap<>();

	public void init(FilterConfig filterConfig) throws ServletException {
		Document doc = getDocument();
		//解析action元素
		NodeList nodeList = doc.getElementsByTagName("action");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element actionEl = (Element) nodeList.item(i);
			String name = actionEl.getAttribute("name");
			String className = actionEl.getAttribute("class");
			String method = actionEl.getAttribute("method");

			ActionConfig actionConfig = new ActionConfig(name, className, method);
			actionConfigMap.put(name, actionConfig);
			//解析result元素
			NodeList resultList = actionEl.getElementsByTagName("result");
			for (int j = 0; j < resultList.getLength(); j++) {
				Element resultEl = (Element) resultList.item(j);
				String resultName = resultEl.getAttribute("name");
				String resultType = resultEl.getAttribute("type");
				String resultPath = resultEl.getTextContent();
				
			}
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		ActionContext actionContext = new ActionContext(req, resp);
		ActionContext.setContext(actionContext);
		
		//获取请求资源的名称
		String requestURI = req.getRequestURI().substring(1);
		try {
			//根据不同的请求资源做不同的操作
			if (!actionConfigMap.containsKey(requestURI)) {
				chain.doFilter(req, resp);
			}
			ActionConfig actionConfig = actionConfigMap.get(requestURI);//获取到对应的action
			Class actionClass = Class.forName(actionConfig.getClassName());
			//创建action对象
			Object actionObject = actionClass.newInstance();
			//调用配置action方法
			Method actionMethod = actionClass.getMethod(actionConfig.getMethod());
			actionMethod.invoke(actionObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {

	}

	public Document getDocument() {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("actions.xml");
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("从classpath根路径加载actions.xml文件失败");
	}

}
