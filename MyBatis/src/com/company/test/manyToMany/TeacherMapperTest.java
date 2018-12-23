package com.company.test.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.company.domain.Student;
import com.company.domain.Teacher;
import com.company.mapper.manyToMany.StudentMapper;
import com.company.mapper.manyToMany.TeacherMapper;
import com.company.util.MyBatisUtil;

public class TeacherMapperTest {

	@Test
	public void testAdd() {
		SqlSession session = MyBatisUtil.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		List<Student> stus = new ArrayList<Student>();
		
		Student student1 = new Student();
		student1.setName("s1");
		Student student2 = new Student();
		student2.setName("s2");
		
		//把学生添加到集合中
		stus.add(student1);
		stus.add(student2);
		
		//保存学生
		studentMapper.add(student1);
		studentMapper.add(student2);

		Teacher teacher = new Teacher();
		teacher.setName("t1");
		teacher.setStus(stus);
		
		//保存老师
		teacherMapper.add(teacher);
		
		//关联关系
		List<Student> students = teacher.getStus();
		for (Student student : students) {
			teacherMapper.updateRealation(teacher.getId(), student.getId());
		}
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testGet() throws InterruptedException {
		SqlSession session = MyBatisUtil.openSession();
		
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		Teacher teacher = teacherMapper.get(3L);
		System.out.println(teacher);
		
		session.close();
		session = MyBatisUtil.openSession();
		
		teacherMapper = session.getMapper(TeacherMapper.class);
		teacher = new Teacher();
		teacher.setName("tt");
		teacherMapper.add(teacher);
		System.out.println(teacher);
		
		session.close();
		
		System.out.println("-------------------");
		
		Thread.sleep(3000);
		
		session = MyBatisUtil.openSession();
		/**
		 * 操作缓存
		 */
		Cache cache = session.getConfiguration().getCache("com.company.mapper.manyToMany.TeacherMapper");
		System.out.println(session.getConfiguration().getCacheNames());//获取缓存的名字
		cache.clear();//清空缓存
		
		teacherMapper = session.getMapper(TeacherMapper.class);
		teacher = teacherMapper.get(3L);
		System.out.println(teacher);
		
		session.close();
	}
	
	
}
