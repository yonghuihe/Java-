package com._520it.shop.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;
	private String productName;
	private BigDecimal salePrice;
	private Long dir_id;
	private String supplier;
	private String brand;
	private Double cutoff;
	private BigDecimal costPrice;
}
