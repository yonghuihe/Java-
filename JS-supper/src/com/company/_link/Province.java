package com.company._link;

import java.util.Arrays;
import java.util.List;

/**
 * 省份
 * @author yonghui
 *
 */
public class Province {

	private Long id;
	private String name;
	
	public Province(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private static List<Province> provinces;
	
	static {
		provinces = Arrays.asList(
				new Province(1L,"广东省"),
				new Province(2L,"四川省"),
				new Province(3L,"浙江省")
				);
	}
	
	public static List<Province> getProvinces() {
		return provinces;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + "]";
	}
}
