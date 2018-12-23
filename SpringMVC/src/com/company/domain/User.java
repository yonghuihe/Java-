package com.company.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private String username;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//前台往后台传递日期参数
	private Date inputTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", inputTime=" + inputTime + "]";
	}

}
