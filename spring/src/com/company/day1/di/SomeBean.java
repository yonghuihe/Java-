package com.company.day1.di;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SomeBean {
	private String name;
	private String password;
	private BigDecimal amount;
	private Integer maxConnection;
	private URL url;

	private OtherBean otherBean;

	private List list;
	private Set set;
	private Map map;

	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public OtherBean getOtherBean() {
		return otherBean;
	}

	public void setOtherBean(OtherBean otherBean) {
		this.otherBean = otherBean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getMaxConnection() {
		return maxConnection;
	}

	public void setMaxConnection(Integer maxConnection) {
		this.maxConnection = maxConnection;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SomeBean [name=" + name + ", password=" + password + ", amount=" + amount + ", maxConnection="
				+ maxConnection + ", url=" + url + ", otherBean=" + otherBean + ", list=" + list + ", set=" + set
				+ ", map=" + map + ", properties=" + properties + "]";
	}

}
