package com._520it.ajax._04_linkage;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@AllArgsConstructor
@Getter
public class Province {
	private Long id;
	private String name;
	@Setter@Getter
	private static List<Province> provinces;
	
	static {
		provinces = Arrays.asList(
			new Province(1L,"广东省"),
			new Province(2L,"四川省"),
			new Province(3L,"浙江省")
		);
	}
}
