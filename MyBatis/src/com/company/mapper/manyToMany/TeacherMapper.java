package com.company.mapper.manyToMany;

import org.apache.ibatis.annotations.Param;

import com.company.domain.Teacher;

public interface TeacherMapper {
	
	public void add(Teacher teacher);
	
	public void updateRealation(@Param("tid")Long tid,@Param("sid")Long sid);
	
	public Teacher get(Long id);
}
