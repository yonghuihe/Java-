package com.company._link;

import java.io.IOException;

import com.company.BaseAction;

public class LinkJqueryAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private Long pid;

	public String getProvice() throws Exception {
		writeJsonString(Province.getProvinces());
		return NONE;
	}

	public String getCityById() throws IOException {
		writeJsonString(new City().getCitiesByProvinces(pid));
		return NONE;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
