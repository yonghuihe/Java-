package com.company.springboot.springjavaconfig._08Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class DateSource {

	private String username;
	private String password;
	private String url;
}
