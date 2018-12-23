package com.company.web;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 封装了登录的结果
 * @author yonghui
 *
 */
public class AjaxResult {
	
	private String success;
	private String msg;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date inputTime;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	

}
