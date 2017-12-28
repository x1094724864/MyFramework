package com.lx.service;

import java.util.List;

import com.lx.entity.Department;

/**
 * 
 * @author lx
 * 
 *         用一个接口承诺一些部门的增删改查方法
 *
 */
public interface IDepartService {
	// 创建部门
	public Long createDepartment(Department department);

	// 修改部门
	public Long modifyDepartment(Department department);

	// 删除部门
	public void removeDepartment(Long id);

	// 获取部门
	public Department getDepartment(Long id);
	
	//获取所有部门信息
	public List<Department> getDepartmentList(Department department);	
	
	public int getDepartmentCount(Department department);
	
	public List<Department> getDepartmentPaginatedList(Department department, int first, int count);
}
