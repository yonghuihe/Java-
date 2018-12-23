package com._520it.day02._03_download;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class DownloadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Setter@Getter
	private String fileName;
	
	private InputStream inputStream;
	
	//给Stream结果类返回流数据
	public InputStream getXxxStream() {
		return inputStream;
	}
	
	public String execute() throws Exception {
		//找到需要下载的资源,使用流的方式读取
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/download");
		//使用流去读取需要下载的资源
		inputStream = new FileInputStream(new File(path,fileName));
		return SUCCESS;
	}
}
