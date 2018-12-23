package com._520it.day02._02_upload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/*
	 	 * <li>[File Name] : File - the actual File</li>
	 	 * <p/>
	 	 * <li>[File Name]ContentType : String - the content type of the file</li>
	 	 * <p/>
	 	 * <li>[File Name]FileName : String - the actual name of the file uploaded (not the HTML name)</li>
	 */
	@Setter
	private File headImg;
	@Setter
	private String headImgContentType;
	@Setter
	private String headImgFileName;

	public String execute() throws Exception {
		//把上传过来的文件保存到项目中/upload/xx.png
		String realPath = ServletActionContext.getServletContext().getRealPath("upload");
		File destFile = new File(realPath,headImgFileName);
		FileUtils.copyFile(headImg, destFile);
		return NONE;
	}
}
