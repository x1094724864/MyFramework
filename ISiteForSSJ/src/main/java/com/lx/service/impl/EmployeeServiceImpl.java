package com.lx.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lx.entity.Employee;
import com.lx.repositroy.IEmployeeDao;
import com.lx.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao iEmployeeDao;

	// 插入员工
	public Long insertEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}

	//保存或修改员工
	public Long saveOrUpdateEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}
	
	// 更新员工
	public Long updateEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}

	// 使用ID查找员工
	public Employee getEmpById(Long id) {
		iEmployeeDao.findOne(id);
		return null;
	}

	// 查找所有员工
	public List<Employee> getAllEmp() {
		List<Employee> employeeList = iEmployeeDao.findAll();
		return employeeList;
	}

	// 删除所有员工
	public void deleteAllEmp() {
		iEmployeeDao.deleteAll();
	}

	// 用id删除员工
	public void deleteEmpById(Long id) {
		iEmployeeDao.delete(id);
	}
	
	// 删除选定员工
	public void deleteEmpByIds(List<Long> ids) {
		iEmployeeDao.deteleByIds(ids);
	}

	// 分页
	public Page<Employee> getPageByFlag(Pageable pageable) {
		// TODO Auto-generated method stub
		return iEmployeeDao.findAll(pageable);
	}

}
