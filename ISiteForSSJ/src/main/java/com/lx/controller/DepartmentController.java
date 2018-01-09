package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.utils.Pager;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	Pager pager = new Pager();

	private ModelAndView mView = new ModelAndView();

	private void getDepartmentList(HttpSession session) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		session.getServletContext().setAttribute("departmentList", departmentList);
	}

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

	// 进入部门列表页面
	// @RequestMapping("listDepart")
	// private ModelAndView listDepart(HttpSession session) {
	// getDepartmentList(session);
	// mView.setViewName("department/depart_list");
	// return mView;
	// }

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

	@RequestMapping("/pageable")
	public String pageable() {
		// Pageable是接口，PageRequest是接口实现
		// PageRequest的对象构造函数有多个，page是页数，初始值是0，size是查询结果的条数，后两个参数参考Sort对象的构造方法
		// Pageable pageable = new PageRequest(0,10);
		// List<Department> list = departmentServiceImpl.getDepartByPage(pageable);
		List<Department> list = departmentServiceImpl.getDepartByPage(0, 10);
		// 查询结果总行数
		// System.out.println(page.getTotalElements());
		System.out.println("ssdsdsdsdsdsd");
		System.out.println(list);
		// 按照当前分页大小，总页数
		// System.out.println(page.getTotalPages());
		// 按照当前页数、分页大小，查出的分页结果集合
		for (Department department : list) {
			System.out.println(department.toString());
		}
		System.out.println("-------15115611515151---------------------");

		return "redirect:listDepart";
	}

}
