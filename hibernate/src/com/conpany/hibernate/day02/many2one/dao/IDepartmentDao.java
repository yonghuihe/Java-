package com.conpany.hibernate.day02.many2one.dao;

import com.conpany.hibernate.day02.many2one.domain.Department;

public interface IDepartmentDao {
	void save(Department e);
	
	Department get(Long id);
}
