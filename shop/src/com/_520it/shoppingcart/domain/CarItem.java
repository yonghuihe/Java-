package com._520it.shoppingcart.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
public class CarItem {
	//商品的ID,名称,单价,数量
	private Long id;
	private String name;
	private BigDecimal salePrice;
	private Integer num;
}
