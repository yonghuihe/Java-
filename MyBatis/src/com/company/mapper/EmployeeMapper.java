package com.company.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.company.domain.Employee;
import com.company.query.EmployeeQueryObject;

/**
 * 使用注解的方式：@Insert、@Update、@Delete
 * @author yonghui
 *
 */
public interface EmployeeMapper {
	//@Insert({"insert into employee (username,password,age,inputTime) values (#{username},#{password},#{age},#{inputTime})"})
	public void add(Employee employee);
	
	//@Update("update employee set username = #{username},password = #{password},age = #{age},inputTime=#{inputTime} where id = #{id}")
	public void edit(Employee employee);
	
	//@Delete("delete from employee where id = #{id}"	)
	public void delete(Long id);
	
	//@Select("select e.id as e_id,e.username as e_username,e.password as e_password,e.age as e_age,e.inputTime as e_inputTime from employee e where e.id = #{id}")
	//@ResultMap("empResultMap")//方式一：与mapper.xml配合使用 
	/*@Results({				//方式二：使用@Results标签
		@Result(column="e_id",property="id",id=true),//id表示是一个id
		@Result(column="e_username",property="username"),
		@Result(column="e_password",property="password"),
		@Result(column="e_age",property="age"),
		@Result(column="e_inputTime",property="inputTime")
	})*/
	public Employee selectOne(Long id);
	
	public List<Employee> selectList();
	
	public List<Employee> getAll();
	
	public List<Employee> query(EmployeeQueryObject qo);
	
	public void deleteAll(List<Long> ids);
	
	public void addAll(List<Employee> employees);

	public Long selectPageResultCount(EmployeeQueryObject qo);
	
	public List<Employee> selectPageResult(@Param("queryObject") EmployeeQueryObject qo);
	
	public Employee login(Map<String,String> map);

	public Employee login(Employee employee);
	
	public Employee login(@Param("username")String username,@Param("password")String password);
}
