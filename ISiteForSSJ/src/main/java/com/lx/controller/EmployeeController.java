package com.lx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EmployeeController {
	private ModelAndView mView = new ModelAndView();
	
	//进入部门列表页面
	@RequestMapping("listEmp")
	private ModelAndView listDepart() {
		mView.setViewName("employee/emp_list");
		return mView;
	}	
	
	//进入部门编辑页面
	@RequestMapping("editEmp")
	private ModelAndView editDepart() {
		mView.setViewName("employee/edit_emp");
		return mView;
	}	
	
	//进入部门修改页面
	@RequestMapping("modEmp")
	private ModelAndView modDepart() {
		mView.setViewName("employee/mod_emp");
		return mView;
	}	
	
	//进入部门删除页面
	@RequestMapping("removeEmp")
	private ModelAndView removeDepart() {
		mView.setViewName("employee/remove_emp");
		return mView;
	}	
}
