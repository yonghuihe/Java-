package com.company._link;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Long pid;
	private City city = new City();

	public String execute() throws Exception {

		/**
		 * [
		 * 		{id:1,name:"广东省"},{id:2,name:"四川省"},{id:3,name:"浙江省"}
		 * ]
		 */
		return NONE;
	}

	public String getProvice() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		List<Province> provinces = Province.getProvinces();
		/*StringBuilder sb = new StringBuilder(80);
		sb.append("[");
		for (Province province : provinces) {
			sb.append("{id:").append(province.getId()).append(",name:'").append(province.getName()).append("'},");
		}
		sb.replace(sb.length()-1, sb.length(), "]");
		resp.getWriter().print(sb);*/
		resp.getWriter().print(JSON.toJSONString(provinces));
		return NONE;
	}

	public String getCityById() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		List<City> cities = city.getCitiesByProvinces(pid);
		/*StringBuilder sb = new StringBuilder(80);
		sb.append("[");
		for (City c : cities) {
			sb.append("{id:").append(c.getId()).append(",name:'").append(c.getName()).append("'},");
		}
		sb.replace(sb.length()-1, sb.length(), "]");
		resp.getWriter().print(sb);*/
		resp.getWriter().print(JSON.toJSONString(cities));
		return NONE;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
