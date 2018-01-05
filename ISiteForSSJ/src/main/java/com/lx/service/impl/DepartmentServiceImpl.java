package com.lx.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lx.entity.Department;
import com.lx.repositroy.IDepartmentDao;
import com.lx.service.IDepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentDao iDepartmentDao;

	// 增加部门
	@Override
	public Long insertDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 保存或者更新部门
	@Override
	public Long saveOrUpdateDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 更新部门
	@Override
	public Long updateDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 查找部门
	@Override
	public Department getDepartById(Long id) {
		Department department = iDepartmentDao.findOne(id);
		return department;
	}

	// 用部门名称查找部门
	@Override
	public Department getDepartByDepartmentName(String departmentName) {
		List<Department> departmentList=iDepartmentDao.findByDepartmentName(departmentName);
		
		Department department = departmentList.get(0);
		return department;
	}

	// 查找所有部门
	@Override
	public List<Department> getAllDepart() {
		List<Department> DepartList = iDepartmentDao.findAll();
		return DepartList;
	}

	// 删除所有部门
	@Override
	public void deleteAllDepart() {
		iDepartmentDao.deleteAll();
	}

	// 删除单个部门
	@Override
	public void deleteDepart(Long id) {
		iDepartmentDao.delete(id);
	}

	// 删除所选部门
	// @Transactional
	@Override
	public void deleteDepartByIds(List<Long> ids) {
		iDepartmentDao.deteleByIds(ids);
	}

	public Page<Department> getPageByFlag(Byte flag, Pageable pageable) {

		// return iDepartmentDao.findAll(pageable);
		System.out.println("-------");
		Page<Department> list = iDepartmentDao.queryFirst10ByFlag(flag, pageable);

		// Page<Department> list = iDepartmentDao.findAll(pageable);

		System.out.println("333333333333333333");
		return list;
	}

}
