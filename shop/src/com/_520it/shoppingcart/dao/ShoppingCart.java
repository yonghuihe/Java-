package com._520it.shoppingcart.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;

import com._520it.shoppingcart.domain.CarItem;

public class ShoppingCart {
	@Getter
	private List<CarItem> list = new ArrayList<>();
	//小计
	public BigDecimal getTotalPrice(){
		BigDecimal sum = BigDecimal.ZERO;
		for (CarItem item : list) {
			//计算一个商品的小计
			BigDecimal total = item.getSalePrice().multiply(new BigDecimal(item.getNum().toString()));
			sum = sum.add(total);
		}
		return sum;
	}
	//往购物车添加商品
	public void addItem(CarItem item){
		//迭代list,如果迭代出来的和传递进来的是同一个,那么数量叠加
		for (CarItem ci : list) {
			if (ci.getId().equals(item.getId())) {
				Integer num = ci.getNum()+item.getNum();
				//然后把叠加之后的个数设置给num
				ci.setNum(num);
				return;
			}
		}
		//如果不是同一个调用list.add方法,添加新的商品
		list.add(item);
	}
	//删除购物车中的商品
	public void removeItem(Long id){
		//使用迭代器,迭代出list中所有的元素
		Iterator<CarItem> it = list.iterator();
		while (it.hasNext()) {
			//判断,如果数据库中的ID和传递进来的ID相同,删除掉该数据
			if (it.next().getId().equals(id)) {
				it.remove();
				return;
			}
		}
	}
}
