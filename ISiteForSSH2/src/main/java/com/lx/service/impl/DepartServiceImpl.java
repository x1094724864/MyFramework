package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.DepartDao;
import com.lx.entity.Department;
import com.lx.service.IDepartService;

@Service
public class DepartServiceImpl implements IDepartService {
	@Autowired
	private DepartDao departDao;

	// 创建部门
	public Long createDepartment(Department department) {

		return departDao.insert(department);
	}

	// 修改部门
	public Long modifyDepartment(Department department) {

		return departDao.update(department);
	}

	// 删除部门
	public Long removeDepartment(Long id) {

		return departDao.delete(id);
	}

	// 获取部门
	public Department getDepartment(Long id) {

		return departDao.getDepart(id);
	}

	public List<Department> getDepartmentList(Department department) {

		return departDao.getDepartmentList(department);
	}

	public int getDepartmentCount(Department department) {
		
		return departDao.getDepartmentCount(department);
	}

	public List<Department> getDepartmentPaginatedList(Department department, int first, int count) {
	 
		return departDao.getDepartmentPaginatedList(department, first, count);
	}
}
