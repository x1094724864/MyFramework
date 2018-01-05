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
	@Override
	public Long insertEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}

	//保存或修改员工
	@Override
	public Long saveOrUpdateEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}
	
	// 更新员工
	@Override
	public Long updateEmp(Employee employee) {
		iEmployeeDao.save(employee);
		return 1L;
	}

	// 使用ID查找员工
	@Override
	public Employee getEmpById(Long id) {
		Employee employee=iEmployeeDao.findOne(id);
		return employee;
	}

	// 查找所有员工
	@Override
	public List<Employee> getAllEmp() {
		List<Employee> employeeList = iEmployeeDao.findAll();
		return employeeList;
	}

	// 删除所有员工
	@Override
	public void deleteAllEmp() {
		iEmployeeDao.deleteAll();
	}

	// 用id删除员工
	@Override
	public void deleteEmpById(Long id) {
		iEmployeeDao.delete(id);
	}
	
	// 删除选定员工
	@Override
	public void deleteEmpByIds(List<Long> ids) {
		iEmployeeDao.deteleByIds(ids);
	}

	// 分页
	@Override
	public Page<Employee> getEmpPage(Pageable pageable) {
		System.out.println("分页开始");
		Page<Employee> empPage=iEmployeeDao.findAll(pageable);
		System.out.println("分页完成");
		return empPage;
	}

}
