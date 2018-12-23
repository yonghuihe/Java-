package com._520it.day01._8_params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class User {
	public User(){
		System.out.println("User.User()");
	}
	private String username;
	private String age;
	private String[] hobby;
}
