package com.company.day1.mvc.web.action;

import com.company.day1.mvc.domain.Employee;
import com.company.day1.mvc.service.IEmployeeService;

public class EmployeeAction {
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String save() {
		Employee e = new Employee();
		e.setName("name");
		employeeService.save(e);
		System.out.println("action,保存对象");
		return "success";
	}
}
