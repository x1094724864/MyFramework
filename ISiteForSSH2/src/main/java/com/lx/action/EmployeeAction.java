package com.lx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.service.impl.DepartServiceImpl;
import com.lx.service.impl.EmpServiceImpl;
import com.lx.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	/**
	 * @author lx
	 */
	private static final long serialVersionUID = 2084201940168839153L;
	Pager pager = new Pager();

	@Autowired
	private EmpServiceImpl empServiceImpl;
	private Employee employee = new Employee();

	//导入部门是为了插入新员工时选择部门属性
	@Autowired
	private DepartServiceImpl departServiceImpl;
	private Department department = new Department();

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 保存或者修改员工信息
	public String saveEmp() {
		Long id = employee.getId();
		if (id == null) {
			empServiceImpl.createEmployee(employee);
			return "insert";
		} else {
			empServiceImpl.modifyEmployee(employee);
			return "update";
		}
	}

	// 删除单个员工信息
	public String deleteEmp() {
		Long id = employee.getId();
		empServiceImpl.removeEmployee(id);
		return "deleted";
	}

	// 删除选定员工
	public String deleteAllEmp() {
		String[] ids = ServletActionContext.getRequest().getParameterValues("emp_ids");
		empServiceImpl.removeAllEmployee(ids);
		return "deleted";
	}

	// 返回员工信息编辑页面
	public String editEmp() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Department> departmentList = departServiceImpl.getDepartmentList(department);
		ActionContext.getContext().put("departmentList", departmentList);
		request.setAttribute("department", department);
		
		Long id=employee.getId();
		if (id!=null) {
			Employee emp=empServiceImpl.getEmployee(id);
			employee.setName(emp.getName());
			employee.setGender(emp.getGender());
			employee.setDepartment_name(emp.getDepartment_name());
			employee.setAddress(emp.getAddress());
			employee.setEducation(emp.getEducation());
			employee.setEmployee_id(emp.getEmployee_id());
			employee.setProfession(emp.getProfession());
			employee.setTel_number(emp.getTel_number());
		}
		return "edit_emp";
	}

	// 返回员工删除页面
	public String removeEmp() {
		return "remove_emp";
	}

	// 返回员工修改页面
	public String modEmp() {
		return "mod_emp";
	}
	
	// 查询所有员工信息
	public String queryEmp() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestPage = request.getParameter("requestPage");

		int recordCount = empServiceImpl.getEmployeeCount(employee);
		pager.init(recordCount, pager.getPageSize(), requestPage);

		List<Employee> employeeList = empServiceImpl.getEmployeePaginatedList(employee, pager.getFirstRow(),
				pager.getRowCount());
		// List<Employee> employeeList=empServiceImpl.getEmployeeList(getEmployee());
		// ServletActionContext.getContext().put("employeeList", employeeList);
		ActionContext.getContext().put("employeeList", employeeList);
		request.setAttribute("pager", pager);
		request.setAttribute("Employee", employee);

		return "emp_list";
	}

}
