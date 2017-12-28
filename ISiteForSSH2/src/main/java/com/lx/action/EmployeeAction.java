package com.lx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.lx.entity.Employee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 保存或者修改员工信息
	public String saveEmp() {
		Long id = employee.getId();
		return "insert";
		/*if (id == null) {
			empServiceImpl.createEmployee(employee);
			return "insert";
		} else {
			empServiceImpl.modifyEmployee(employee);
			return "update";
		}*/
	}

	// 删除员工信息
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
	public String addOrModifyEmp() {
		return "addOrModify";
	}

	// 返回员工删除页面
	public String removeEmp() {
		return "remove_emp";
	}

	// 查询所有员工信息
	public String queryEmp() throws Exception  {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestPage = request.getParameter("requestPage");

		int recordCount = empServiceImpl.getEmployeeCount(employee);
		pager.init(recordCount, pager.getPageSize(), requestPage);

		List<Employee> employeeList = empServiceImpl.getEmployeePaginatedList(employee, pager.getFirstRow(),
				pager.getRowCount());
//		List<Employee> employeeList=empServiceImpl.getEmployeeList(getEmployee());
//		ServletActionContext.getContext().put("employeeList", employeeList);
		ActionContext.getContext().put("employeeList", employeeList);
		request.setAttribute("pager", pager);
		request.setAttribute("Employee", employee);
		
		return "emp_list";
	}
	
	//测试获取所有员工
//	public  name() {
//		
//	}
	
	
}
