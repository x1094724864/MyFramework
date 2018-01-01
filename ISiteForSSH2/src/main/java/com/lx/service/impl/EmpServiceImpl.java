package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.EmployeeDao;
import com.lx.entity.Employee;
import com.lx.service.IEmployeeService;

@Service
public class EmpServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	// 添加员工
	public Long createEmployee(Employee employee) {
		return employeeDao.insert(employee);
	}

	// 修改员工
	public Long modifyEmployee(Employee employee) {
		return employeeDao.update(employee);
	}

	// 删除员工
	public Long removeEmployee(Long id) {
		return employeeDao.delete(id);
	}

	// 删除选定员工
	public void removeAllEmployee(String[] ids) {
		employeeDao.deleteAll(ids);
	}

	// 获取员工
	public Employee getEmployee(Long id) {
		return employeeDao.getEmployee(id);
	}

	// 查询员工
	public List<Employee> getEmployeeList(Employee employee) {
		return employeeDao.getEmployeeList(employee);
	}

	public int getEmployeeCount(Employee employee) {
		return employeeDao.getEmployeeCount(employee);
	}

	public List<Employee> getEmployeePaginatedList(Employee employee, int first, int count) {
		return employeeDao.getEmployeePaginatedList(employee, first, count);
	}

}
