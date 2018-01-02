package com.lx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.service.impl.DepartmentServiceImpl;

@Controller
// @RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	private ModelAndView mView = new ModelAndView();

	// 进入部门列表页面
	@RequestMapping("listDepart")
	private ModelAndView listDepart() {
		mView.setViewName("department/depart_list");
		return mView;
	}

	// 进入部门编辑页面
	@RequestMapping("editDepart")
	private ModelAndView editDepart() {
		mView.setViewName("department/edit_depart");
		return mView;
	}

	// 进入部门修改页面
	@RequestMapping("modDepart")
	private ModelAndView modDepart() {
		mView.setViewName("department/mod_depart");
		return mView;
	}

	// 进入部门删除页面
	@RequestMapping("removeDepart")
	private ModelAndView removeDepart() {
		mView.setViewName("department/remove_depart");
		return mView;
	}

	// 保存、更新部门
	@RequestMapping("saveDepart")
	private ModelAndView saveDepart(Department department) {
		departmentServiceImpl.insertDepart(department);
		mView.setViewName("department/depart_list");
		return mView;
	}

}
