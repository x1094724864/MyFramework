package com.lx.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lx.entity.Department;
import com.lx.repository.DepartmentRepository;
import com.lx.service.IDepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	// 增加部门
	@Override
	public Long insertDepart(Department department) {
		departmentRepository.save(department);
		return 1L;
	}

	// 保存或者更新部门
	@Override
	public Long saveOrUpdateDepart(Department department) {
		departmentRepository.save(department);
		return 1L;
	}

	// 更新部门
	@Override
	public Long updateDepart(Department department) {
		departmentRepository.save(department);
		return 1L;
	}

	// 查找部门
	@Override
	public Department getDepartById(Long id) {
		Department department = departmentRepository.findOne(id);
		return department;
	}

	// 用部门名称查找部门
	@Override
	public Department getDepartByDepartmentName(String departmentName) {
		List<Department> departmentList=departmentRepository.findByDepartmentName(departmentName);
		Department department = departmentList.get(0);
		return department;
	}

	public List<Department> getDepartsByDepartmentName(String departmentName) {
		List<Department> departmentList=departmentRepository.findByDepartmentName(departmentName);
		return departmentList;
	}
	
	// 用部门编号查找部门
	public List<Department> getDepartsByDepartmentNum(Integer departmentNum) {
		List<Department> departmentList=departmentRepository.findByDepartmentNum(departmentNum);
		return departmentList;
	}
	
	
	
	
	
	
	// 查找所有部门
	@Override
	public List<Department> getAllDepart() {
		List<Department> departList = departmentRepository.findAll();
		return departList;
	}

	// 删除所有部门
	@Override
	public void deleteAllDepart() {
		departmentRepository.deleteAll();
	}

	// 删除单个部门
	@Override
	public void deleteDepart(Long id) {
		departmentRepository.delete(id);
	}

	// 删除所选部门
	// @Transactional
	@Override
	public void deleteDepartByIds(List<Long> ids) {
		departmentRepository.deteleByIds(ids);
	}

	//获取总记录数
	public int getRecordCount() {
		System.out.println("查询总记录数");
		int recordCount;
		List<Department> departList = departmentRepository.findAll();
		if (departList.size()>0) {
			recordCount=departList.size();
			return recordCount;
		}
		return 0;
	}
	//分页
	public List<Department> getDepartByPage( int firstRow, int rowCount){
		return departmentRepository.findDepartmentByPage(firstRow, rowCount);
	}
	

}
