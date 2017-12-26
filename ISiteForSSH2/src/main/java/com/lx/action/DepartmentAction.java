package com.lx.action;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import com.lx.entity.Department;
import com.lx.service.impl.DepartServiceImpl;
import com.lx.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class DepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Pager pager = new Pager();

	@Autowired
	private DepartServiceImpl departService;
	private Department department = new Department();

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// 保存或者修改
	public String saveDepart() {
		// 先获取部门id
		Long id = department.getId();
		if (id == null) {// 假设id为空，则代表是新的部门，使用保存方法
			departService.createDepartment(department);
			 return "insert";
		} else {
			// 假设id不为空，则代表是旧的部门，使用修改方法
			departService.modifyDepartment(department);
		}
		return "update";
	}

	// 返回修改所对应的页面
	/*
	 * public String modDepart() { return "mod"; }
	 */

	// 返回删除所对应的页面
	public String removeDepart() {
		return "delete";
	}

	// 删除所选部门
	public String deleteDepart() {

		Long id = department.getId();
		departService.removeDepartment(id);
		return "deleted";
	}

	// 返回部门信息编辑页面
	public String addOrModifyDepart() {
		Long id = department.getId();
		if (id != null) {
			Department depart = departService.getDepartment(id);
			department.setDepartment_num(depart.getDepartment_num());
			department.setDepartment_name(depart.getDepartment_name());
			department.setDepartment_desc(depart.getDepartment_desc());

		}
		// departService.modifyDepartment(department);
		return "addOrModify";
	}

	// 查询所有部门信息
	public String queryDepart() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestPage = request.getParameter("requestPage");

		int recordCount = departService.getDepartmentCount(department);
		pager.init(recordCount, pager.getPageSize(), requestPage);

		List<Department> departmentList = departService.getDepartmentPaginatedList(department, pager.getFirstRow(),
				pager.getRowCount());
		ActionContext.getContext().put("departmentList", departmentList);
		request.setAttribute("pager", pager);
		request.setAttribute("department", department);

		return "list";
	}
}
