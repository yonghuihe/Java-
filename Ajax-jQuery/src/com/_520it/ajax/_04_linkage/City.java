package com._520it.ajax._04_linkage;

import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString@Getter
public class City {
	private Long id;
	private String name;
	
	public static List<City> getCitiesByProvinceId(Long id){
		List<City> cities = null;
		if (id == 1L) {
			cities = Arrays.asList(
					new City(11L,"广东市"),
					new City(12L,"深圳市"),
					new City(13L,"珠海市"),
					new City(14L,"汕头市"),
					new City(15L,"佛山市"),
					new City(16L,"韶关市")
			);
		} else if (id == 2L){
			cities = Arrays.asList(
					new City(21L,"成都市"),
					new City(22L,"绵阳市"),
					new City(23L,"自贡市"),
					new City(24L,"泸州市"),
					new City(25L,"德阳市"),
					new City(26L,"广元市")
			);
		} else if (id == 3L){
			cities = Arrays.asList(
					new City(31L,"杭州市"),
					new City(32L,"宁波市"),
					new City(33L,"温州市"),
					new City(34L,"绍兴市"),
					new City(35L,"湖州市"),
					new City(36L,"嘉兴市")
			);	
		} else {
			cities = java.util.Collections.emptyList();
		}
		return cities;
	}
}
