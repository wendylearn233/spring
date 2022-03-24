package com.ud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud.bean.Department;
import com.ud.dao.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;

	//查询所有社团
	public List<Department> getDepts() {
		List<Department> list = departmentMapper.selectByExample(null);
		return list;
	}
}
