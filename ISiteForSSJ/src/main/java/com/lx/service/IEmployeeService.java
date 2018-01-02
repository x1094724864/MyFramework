package com.lx.service;

import java.util.List;

import com.lx.entity.Employee;

public interface IEmployeeService {
	    // 创建员工
		public Long createEmployee(Employee employee);

		// 修改员工
		public Long modifyEmployee(Employee employee);

		// 删除员工
		public Long removeEmployee(Long id);
		
		//删除所选员工
		public void removeAllEmployee(String[] ids);
		
		// 获取员工
		public Employee getEmployee(Long id);
		
		//获取所有员工信息
		public List<Employee> getEmployeeList(Employee employee);	
		
		public int getEmployeeCount(Employee employee);
		
		public List<Employee> getEmployeePaginatedList(Employee employee, int first, int count);
}
