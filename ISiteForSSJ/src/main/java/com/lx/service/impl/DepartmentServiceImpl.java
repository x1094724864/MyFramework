package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lx.entity.Department;
import com.lx.repositroy.IDepartmentDao;
import com.lx.service.IDepartmentService;
@Service
//@Component
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentDao iDepartmentDao;

	// 增加部门
	public Long insertDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 更新部门
	public Long updateDepart(Department department) {
		iDepartmentDao.saveAndFlush(department);
		return 1L;
	}

	// 查找部门
	public Department getDepartById(Long id) {
		Department department = iDepartmentDao.findOne(id);
		return department;
	}

	// 查找所有部门
	public List<Department> getAllDepart() {
		// TODO Auto-generated method stub
		List<Department> list = iDepartmentDao.findAll();
		return list;
	}

	// 删除所有部门
	public void deleteAllDepart() {
		iDepartmentDao.deleteAll();
	}

	// 删除所选部门
	public void deleteDepartByIds(List<Long> ids) {
		iDepartmentDao.deteleByIds(ids);
	}

}
