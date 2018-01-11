package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.entity.Users;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.utils.Pager;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	Pager pager = new Pager();

	private ModelAndView mView = new ModelAndView();

	// 分页部门列表
	private List<Department> getDepartWithPage(String requestPage) {
		int recordCount = departmentServiceImpl.getRecordCount();
		pager.init(recordCount, pager.getPageSize(), requestPage);
		int firstRow = pager.getFirstRow();
		int rowCount = pager.getRowCount();
		List<Department> departmentPageList = departmentServiceImpl.getDepartByPage(firstRow, rowCount);
		// request.setAttribute("pager", pager);
		return departmentPageList;
	}

	// 部门分页列表
	@RequestMapping("listDepart")
	private ModelAndView listDepart(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		List<Department> departmentList = getDepartWithPage(requestPage);
		session.getServletContext().setAttribute("departmentList", departmentList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("department/depart_list");
		return mView;
	}

	// 进入部门编辑页面
	@RequestMapping("editDepart")
	private @ResponseBody ModelAndView editDepart(HttpSession session, Long id) {
		Department department = departmentServiceImpl.getDepartById(id);
		mView.addObject("department", department);
		mView.setViewName("department/edit_depart");
		return mView;
	}

	// 进入部门修改页面
	@RequestMapping("modDepart")
	private ModelAndView modDepart(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		// getDepartmentList(session);
		List<Department> departmentList = getDepartWithPage(requestPage);
		session.getServletContext().setAttribute("departmentList", departmentList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("department/mod_depart");
		return mView;
	}

	// 进入部门删除页面
	@RequestMapping("removeDepart")
	private ModelAndView removeDepart(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		// getDepartmentList(session);
		List<Department> departmentList = getDepartWithPage(requestPage);
		session.getServletContext().setAttribute("departmentList", departmentList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("department/remove_depart");
		return mView;
	}

	// 保存、更新部门
	@RequestMapping(value = "saveDepart")
	private String saveDepart(@ModelAttribute Department department) {
		departmentServiceImpl.saveOrUpdateDepart(department);
		return "redirect:listDepart";
	}

	// 删除单个部门
	@RequestMapping(value = "deleteDepartById")
	private String deleteDepart(@RequestParam("id") Long id) {
		departmentServiceImpl.deleteDepart(id);
		return "redirect:removeDepart";
	}

	// 根据所选ids删除部门
	@RequestMapping(value = "deleteDepartByIds")
	private String deleteAllDepartByIds(@RequestParam("depart_ids") String[] ids) {
		if (ids != null) {
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Long.parseLong(ids[i]));
			}
			System.out.println(list);
			departmentServiceImpl.deleteDepartByIds(list);
		}
		System.out.println("执行方法");
		return "redirect:removeDepart";
	}

	
	//部门名验证部门是否存在
	@RequestMapping("departIsExistByDepartName")
	@ResponseBody
	public boolean departIsExistByDepartName(HttpServletRequest request, @RequestParam("departmentName") String departmentName) {
		List<Department> list = departmentServiceImpl.getDepartsByDepartmentName(departmentName);
		if (list.size() > 0) {
			return true; // 表示存在
		}
		return false; // 表示不存在
	}
	
	//部门编号验证部门是否存在
	@RequestMapping("departIsExistByDepartNum")
	@ResponseBody
	public boolean departIsExistByDepartNum(HttpServletRequest request, @RequestParam("departmentNum") Integer departmentNum) {
		List<Department> list = departmentServiceImpl.getDepartsByDepartmentNum(departmentNum);
		if (list.size() > 0) {
			return true; // 表示存在
		}
		return false; // 表示不存在
	}
	
	
	
}
