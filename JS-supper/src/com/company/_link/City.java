package com.company._link;

import java.util.Arrays;
import java.util.List;

/**
 * 城市
 * @author yonghui
 *
 */
public class City {
	private Long id;
	private String name;
	
	public City(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public City() {
		super();
	}

	public List<City> getCitiesByProvinces(Long id){
		List<City> cities = null;
		if (id == 1){
			cities = Arrays.asList(
					new City(1L, "广州市"),
					new City(1L, "深圳市"),
					new City(1L, "珠海市"),
					new City(1L, "汕头市"),
					new City(1L, "佛山市"),
					new City(1L, "韶关市")
					);
		} else if (id == 2){
			cities = Arrays.asList(
					new City(1L, "成都市"),
					new City(1L, "绵阳市"),
					new City(1L, "自贡市"),
					new City(1L, "泸州市"),
					new City(1L, "德阳市"),
					new City(1L, "广元市")
					);
		} else if (id == 3){
			cities = Arrays.asList(
					new City(1L, "杭州市"),
					new City(1L, "宁波市"),
					new City(1L, "温州市"),
					new City(1L, "绍兴市"),
					new City(1L, "潮州市"),
					new City(1L, "嘉兴市")
					);
		} 
		return cities;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	
}
