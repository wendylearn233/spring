package com.ud.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ud.bean.Department;
import com.ud.bean.Student;
import com.ud.dao.DepartmentMapper;
import com.ud.dao.StudentMapper;

import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext*.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	StudentMapper studentMapper;

	@Autowired
	SqlSession sq;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	@Test
	public void test() {
//		System.out.println(departmentMapper);
		//org.apache.ibatis.binding.MapperProxy@53093491

		sq.getMapper(Student.class);
		for (int i=0 ;i<200; i++){
			String uid = UUID.randomUUID().toString().substring(0,5);
			studentMapper.insertSelective(new Student(null, "uid", "M", uid+"yaopu@163.com", 3));
			sq.commit();
		}
		
//		//插入三个部门（使用逆向工程自动生成的方法）
//		departmentMapper.insertSelective(new Department(null, "学生部"));
//		departmentMapper.insertSelective(new Department(null, "信息部"));
//		departmentMapper.insertSelective(new Department(null, "记者部"));
//		departmentMapper.insertSelective(new Department(null, "实创部"));
		
		//插入学生
		
//		studentMapper.insertSelective(new Student(null, "白曜溥", "M", "yaopu@163.com", 3));
//		studentMapper.insertSelective(new Student(null, "柴高岩", "M", "gaoyan@163.com", 1));

//		
//		
//		System.out.println("运行成功");
	}
}
