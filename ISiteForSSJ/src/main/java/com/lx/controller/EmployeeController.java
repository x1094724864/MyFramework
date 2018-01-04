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
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	private ModelAndView mView = new ModelAndView();

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	// 获取部门列表

	// 获取员工列表
	private void getEmployeeList(HttpSession session) {
		List<Employee> employeeList = employeeServiceImpl.getAllEmp();
		session.setAttribute("employeeList", employeeList);
	}

	// 进入员工列表页面
	@RequestMapping("listEmp")
	private ModelAndView listEmp(HttpSession session) {
		getEmployeeList(session);
		mView.setViewName("employee/emp_list");
		return mView;
	}

	// 进入员工编辑页面
	@RequestMapping("editEmp")
	private ModelAndView editEmp(HttpSession session, HttpServletRequest request) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		request.setAttribute("List", departmentList);
		mView.setViewName("employee/edit_emp");
		return mView;
	}

	// 进入员工修改页面
	@RequestMapping("modEmp")
	private ModelAndView modEmp(HttpSession session) {
		getEmployeeList(session);
		mView.setViewName("employee/mod_emp");
		return mView;
	}

	// 进入员工删除页面
	@RequestMapping("removeEmp")
	private ModelAndView removeEmp(HttpSession session) {
		getEmployeeList(session);
		mView.setViewName("employee/remove_emp");
		return mView;
	}

	// 保存、更新员工
	@RequestMapping("saveEmployee")
	private String saveEmp(@ModelAttribute Employee employee) {
		employeeServiceImpl.saveOrUpdateEmp(employee);
		return "redirect:listEmp";
	}

	// 删除单个部门
	@RequestMapping(value = "deleteEmpById")
	private String deleteEmpById(@RequestParam("id") Long id) {
		employeeServiceImpl.deleteEmpById(id);
		return "redirect:removeEmp";
	}

	// 根据所选ids删除员工
	@RequestMapping(value = "deleteEmpByIds")
	private String deleteAllEmpByIds(@RequestParam("emp_ids") String[] ids) {
		if (ids != null) {
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Long.parseLong(ids[i]));
			}
			System.out.println(list);
			employeeServiceImpl.deleteEmpByIds(list);
		}
		System.out.println("执行方法");
		return "redirect:removeEmp";
	}

}
