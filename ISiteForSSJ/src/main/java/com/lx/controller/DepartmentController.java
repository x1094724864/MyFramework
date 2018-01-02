package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.service.impl.DepartmentServiceImpl;

@Controller
// @RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	private ModelAndView mView = new ModelAndView();

//	public List<Department> getDepartmentList(HttpSession session) {
//		List<Department> departmentList = departmentServiceImpl.getAllDepart();
//		session.setAttribute("departmentList", departmentList);
//	}
	private void getDepartmentList(HttpSession session) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		session.setAttribute("departmentList", departmentList);
	}
	
	
	// 进入部门列表页面
	@RequestMapping("listDepart")
	private ModelAndView listDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/depart_list");
		return mView;
	}

	// 进入部门编辑页面
	@RequestMapping("editDepart")
	
//	private @ResponseBody ModelAndView editDepart(HttpSession session,Department department) {
	private @ResponseBody ModelAndView editDepart(HttpSession session,Long id) {
		Department department =departmentServiceImpl.getDepartById(id);
		
		mView.addObject("department", department);
		
		mView.setViewName("department/edit_depart");
		return mView;
	}

	// 进入部门修改页面
	@RequestMapping("modDepart")
	private ModelAndView modDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/mod_depart");
		return mView;
	}

	// 进入部门删除页面
	@RequestMapping("removeDepart")
	private ModelAndView removeDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/remove_depart");
		return mView;
	}

	// 保存、更新部门
//	@RequestMapping(value = "saveDepart")
//	private ModelAndView saveDepart(@ModelAttribute Department department) {
//		departmentServiceImpl.insertDepart(department);
//		mView.setViewName("department/depart_list");
//		return mView;
//	}
	@RequestMapping(value = "saveDepart")
	private String saveDepart(@ModelAttribute Department department) {
		departmentServiceImpl.insertDepart(department);
//		mView.setViewName("department/depart_list");
		return "redirect:listDepart";
	}

	//删除单个部门
//	@RequestMapping(value = "deleteDepart")
//	private ModelAndView deleteDepart(@RequestParam("id") Long id) {
//		departmentServiceImpl.deleteDepart(id);
//		mView.setViewName("department/deleted");
//		return mView;
//	}
	@RequestMapping(value = "deleteDepart")
	private String deleteDepart(@RequestParam("id") Long id) {
		departmentServiceImpl.deleteDepart(id);
		return "redirect:removeDepart";
	}
	
//	@RequestMapping(value = "editDepart")
//	private String editDepart(@RequestParam("id") Long id) {
//		departmentServiceImpl.updateDepart(department);
//		return "redirect:removeDepart";
//	}
	
//	 获取所有部门列表
	 @RequestMapping(value ="deleteDepartByIds")
	 private ModelAndView deleteAllDepart(@RequestParam("depart_ids") String[] ids) {
		if (ids!=null) {
			List<Long> list=new ArrayList<Long>();
			 for (int i = 0; i < ids.length; i++) {
				 list.add(Long.parseLong(ids[i]));
				}
			 System.out.println(list);
			 departmentServiceImpl.deleteDepartByIds(list);
		}
	 mView.setViewName("department/depart_list");
	 return mView;
	 }

}
