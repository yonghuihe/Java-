package com.company._link;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Long pid;
	private City city = new City();

	public String execute() throws Exception {

		/**
		 * <option value="-1">省份</option>
		 */
		return NONE;
	}

	public String getProvice() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		List<Province> provinces = Province.getProvinces();
		StringBuilder sb = new StringBuilder(80);
		for (Province province : provinces) {
			sb.append("<option value=\"" + province.getId() + "\">" + province.getName() + "</option>");
		}
		resp.getWriter().print(sb);
		return NONE;
	}

	public String getCityById() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		List<City> cities = city.getCitiesByProvinces(pid);
		for (City c : cities) {
			resp.getWriter().print("<option value=\"" + c.getId() + "\">" + c.getName() + "</option>");
		}
		return NONE;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
