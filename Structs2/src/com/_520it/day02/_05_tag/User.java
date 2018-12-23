package com._520it.day02._05_tag;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
}
