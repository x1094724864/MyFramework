package com.lx.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lx.entity.Department;
import com.lx.repositroy.IDepartmentDao;
import com.lx.service.IDepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentDao iDepartmentDao;
//	@Autowired
	TypedQuery<Department> query;
	// 增加部门
	public Long insertDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 更新部门
	public Long updateDepart(Department department) {
		iDepartmentDao.save(department);
		return 1L;
	}

	// 查找部门
	public Department getDepartById(Long id) {
		Department department = iDepartmentDao.findOne(id);
		return department;
	}

	// 查找所有部门
	public List<Department> getAllDepart() {
		List<Department> list = iDepartmentDao.findAll();
		return list;
	}

	// 删除所有部门
	public void deleteAllDepart() {
		iDepartmentDao.deleteAll();
	}

	// 删除单个部门
	public void deleteDepart(Long id) {
		iDepartmentDao.delete(id);
	}

	// 删除所选部门
	// @Transactional
	public void deleteDepartByIds(List<Long> ids) {
		iDepartmentDao.deteleByIds(ids);
	}

//	public int getDepartmentCount(Department department) {
//		long count = iDepartmentDao.count();
//		if (count > 0) {
//			return (int) count;
//		}
//		return 0;
//	}
//
//	public List<Department> getDepartmentPaginatedList(Department department, int first, int count) {
//		query.setFirstResult(first);
//		query.setMaxResults(count);
//		return (List<Department>) query.getResultList();

//	}

	Page<Department> get(){
		
		iDepartmentDao.findByName(departmentName, pageable);
		
		
	}
	
}
