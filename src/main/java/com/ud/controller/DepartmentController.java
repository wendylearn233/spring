package com.ud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.bean.Department;
import com.ud.bean.Msg;
import com.ud.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	//以JSON的形式返回所有的社团信息
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
	
	
	
}
