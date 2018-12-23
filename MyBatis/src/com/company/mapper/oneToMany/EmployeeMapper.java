package com.company.mapper.oneToMany;

import org.apache.ibatis.annotations.Param;

import com.company.domain.Employee;

public interface EmployeeMapper {
	public void add(Employee employee);
	
	public Employee get(Long did);
	
	public void updateRealation(@Param("did")Long did,@Param("eid")Long eid);
	
	public void updateDeptId(Long did);
}
