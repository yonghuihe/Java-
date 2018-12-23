package com.conpany.hibernate.day03.cascade.dao;

import com.conpany.hibernate.day03.cascade.domain.SaleBill;

public interface ICascadeDao {
	void save(SaleBill bill);
	
	void delete(Long id);
	
	void update(SaleBill bill);
	
	void update2(SaleBill bill);

	SaleBill get(Long id);
}
