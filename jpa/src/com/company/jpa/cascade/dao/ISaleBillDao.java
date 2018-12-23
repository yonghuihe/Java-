package com.company.jpa.cascade.dao;

import com.company.jpa.cascade.domain.SaleBill;

public interface ISaleBillDao {
	void save(SaleBill bill);
	
	void delete(Long id);
	
	void update(SaleBill bill);
	
	SaleBill get(Long id);

	void update2(SaleBill bill);
}
