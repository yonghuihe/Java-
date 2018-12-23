package com.company.mapper.manyToMany;

import com.company.domain.Student;

public interface StudentMapper {
	
	public void add(Student student);
	
	public Student get(Long id);
	
	public Student getStuByTeaId(Long tid);
}
