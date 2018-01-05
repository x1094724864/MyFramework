package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.service.IEmployeeService;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private IEmployeeService iEmployeeService;
	
	private ModelAndView mView = new ModelAndView();

	// private Employee employee = new Employee();

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

	// 进入员工详细信息页面
	@RequestMapping("detailsEmp")
	private ModelAndView detailsEmp(HttpSession session, Employee employee) {
		Long id = employee.getId();

		Employee emp = employeeServiceImpl.getEmpById(id);
		mView.addObject("emp", emp);
		mView.setViewName("employee/emp_details");
		return mView;
	}

	// 进入员工编辑页面
	@RequestMapping("editEmp")
	private ModelAndView editEmp(HttpSession session, HttpServletRequest request, Employee employee) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		// String departmentName = employee.getDepartmentName();
		// employee.setDepartment(departmentServiceImpl.getDepartByDepartmentName(departmentName));
		Long id = employee.getId();
		if (id != null) {
			Employee emp = employeeServiceImpl.getEmpById(id);
			employee.setName(emp.getName());
			employee.setGender(emp.getGender());
			employee.setDepartmentName(emp.getDepartmentName());
			employee.setDepartment(emp.getDepartment());
			employee.setAddress(emp.getAddress());
			employee.setEducation(emp.getEducation());
			employee.setEmployee_id(emp.getEmployee_id());
			employee.setProfession(emp.getProfession());
			employee.setTel_number(emp.getTel_number());
		}
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
	@RequestMapping("saveEmp")
	private String saveEmp(@ModelAttribute Employee employee) {

		String departmentName = employee.getDepartmentName();
		employee.setDepartment(departmentServiceImpl.getDepartByDepartmentName(departmentName));
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

	
	
	
	
	
	
	//分页
	@RequestMapping("listEmpPage")
	private ModelAndView listEmpPage(HttpSession session) {
		List<Employee> employeeList=getEmpList();
		session.setAttribute("employeeList", employeeList);
		mView.setViewName("employee/emp_list");
		return mView;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmpList() {
		
		Pageable pageable=new PageRequest(0, 8);
		List<Employee> empList=(List<Employee>) iEmployeeService.getEmpPage(pageable);
		
		return empList;
	}
	
	
	
	
	
	
}
