package com.company.day2.mvc.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.day2.mvc.domain.Employee;
import com.company.day2.mvc.service.IEmployeeService;

@Controller("employeeAction")
@Scope("prototype")
public class EmployeeAction {
	@Autowired
	private IEmployeeService employeeService;
	
	public String save() {
		Employee e = new Employee();
		e.setName("name");
		employeeService.save(e);
		System.out.println("action,保存对象");
		return "success";
	}
}
