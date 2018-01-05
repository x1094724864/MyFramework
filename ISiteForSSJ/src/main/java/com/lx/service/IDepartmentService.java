package com.lx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lx.entity.Department;

public interface IDepartmentService {

	// @Autowired
	// private IDepartmentDao iDepartmentDao;
	//
	// 增加部门
	Long insertDepart(Department department);

	// 更新部门
	Long updateDepart(Department department);

	// 用id查找部门
	Department getDepartById(Long id);

	//用部门名称查找部门
	Department getDepartByDepartmentName(String departmentName);
	
	// 查找所有部门
	List<Department> getAllDepart();

	// 删除所有部门
	void deleteAllDepart();

	// 删除所选部门
	void deleteDepartByIds(List<Long> ids);
	
	//分页
	Page<Department> getPageByFlag(Byte flag,Pageable pageable);

	void deleteDepart(Long id);

	Long saveOrUpdateDepart(Department department);
}
