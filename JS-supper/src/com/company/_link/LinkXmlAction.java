package com.company._link;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.opensymphony.xwork2.ActionSupport;

public class LinkXmlAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Long pid;
	private City city = new City();

	/**
	 * <dates> <date id=xx>xx省</date> <date id=xx>xx省</date>
	 * <date id=xx>xx省</date> </dates>
	 * 
	 * @return
	 */
	public String getProvice() throws Exception {

		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/xml; charset=UTF-8");
		List<Province> provinces = Province.getProvinces();

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element dates = doc.createElement("dates");
		doc.appendChild(dates);

		for (Province province : provinces) {
			Element date = doc.createElement("date");
			date.setAttribute("id", province.getId().toString());
			date.setTextContent(province.getName());
			dates.appendChild(date);
		}
		// 同步转换
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),
				new StreamResult(resp.getWriter()));
		return NONE;
	}

	public String getCityById() throws Exception {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/xml; charset=UTF-8");
		List<City> cities = city.getCitiesByProvinces(pid);

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element dates = doc.createElement("dates");
		doc.appendChild(dates);

		for (City c : cities) {
			Element date = doc.createElement("date");
			date.setAttribute("id", c.getId().toString());
			date.setTextContent(c.getName());
			dates.appendChild(date);
		}
		// 同步转换
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),
				new StreamResult(resp.getWriter()));
		return NONE;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return pid;
	}
}
