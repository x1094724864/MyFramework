package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.repositroy.IDepartmentDao;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.utils.Pager;

@Controller
// @RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	@Autowired
//	private Pager pager;
	private IDepartmentDao iDepartmentDao;

	private ModelAndView mView = new ModelAndView();

	// public List<Department> getDepartmentList(HttpSession session) {
	// List<Department> departmentList = departmentServiceImpl.getAllDepart();
	// session.setAttribute("departmentList", departmentList);
	// }
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
	// @RequestMapping(value = "saveDepart")
	// private ModelAndView saveDepart(@ModelAttribute Department department) {
	// departmentServiceImpl.insertDepart(department);
	// mView.setViewName("department/depart_list");
	// return mView;
	// }
	@RequestMapping(value = "saveDepart")
	private String saveDepart(@ModelAttribute Department department) {
		departmentServiceImpl.insertDepart(department);
		// mView.setViewName("department/depart_list");
		return "redirect:listDepart";
	}

	// 删除单个部门
	// @RequestMapping(value = "deleteDepart")
	// private ModelAndView deleteDepart(@RequestParam("id") Long id) {
	// departmentServiceImpl.deleteDepart(id);
	// mView.setViewName("department/deleted");
	// return mView;
	// }
	@RequestMapping(value = "deleteDepart")
	private String deleteDepart(@RequestParam("id") Long id) {
		departmentServiceImpl.deleteDepart(id);
		return "redirect:removeDepart";
	}

	// @RequestMapping(value = "editDepart")
	// private String editDepart(@RequestParam("id") Long id) {
	// departmentServiceImpl.updateDepart(department);
	// return "redirect:removeDepart";
	// }

	// 获取所有部门列表
	@RequestMapping(value = "deleteDepartByIds")
	private String deleteAllDepart(@RequestParam("ids") String[] ids) {
		if (ids != null) {
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Long.parseLong(ids[i]));
			}
			System.out.println(list);
			departmentServiceImpl.deleteDepartByIds(list);
		}
		System.out.println("执行方法");
		// mView.setViewName("department/depart_list");
		// return mView;
		return "redirect:removeDepart";
	}

//	@RequestMapping("listDepartPage")
//	private String getDepartmentListPage(HttpServletRequest request) {
//		Department department = new Department();
//
//		String requestPage = request.getParameter("requestPage");
//
//		int recordCount = departmentServiceImpl.getDepartmentCount(department);
//		pager.init(recordCount, pager.getPageSize(), requestPage);
//
//		List<Department> departmentList = departmentServiceImpl.getDepartmentPaginatedList(department,
//				pager.getFirstRow(), pager.getRowCount());
//
//		request.getServletContext().setAttribute("departmentList", departmentList);
//
//		// request.getServletContext().put("departmentList", departmentList);
//		request.setAttribute("department", department);
//		request.setAttribute("pager", pager);
//
//		return "redirect:listDepart";
//	}
	
	
	@RequestMapping("/pageable")
	  public void pageable(){
	    //Pageable是接口，PageRequest是接口实现
	    //PageRequest的对象构造函数有多个，page是页数，初始值是0，size是查询结果的条数，后两个参数参考Sort对象的构造方法
	    Pageable pageable = new PageRequest(0,3, Sort.Direction.DESC,"id");
	    Page<Department> page = iDepartmentDao.findByName("15",pageable);
	    //查询结果总行数
	    System.out.println(page.getTotalElements());
	    //按照当前分页大小，总页数
	    System.out.println(page.getTotalPages());
	    //按照当前页数、分页大小，查出的分页结果集合
	    for (Department department: page.getContent()) {
	      System.out.println(department.toString());
	    }
	    System.out.println("-------------------------------------------");
	  }
	

}
