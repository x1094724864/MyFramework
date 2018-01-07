package com.lx.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.repository.EmployeeRepository;
import com.lx.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	// 插入员工
	@Override
	public Long insertEmp(Employee employee) {
		employeeRepository.save(employee);
		return 1L;
	}

	//保存或修改员工
	@Override
	public Long saveOrUpdateEmp(Employee employee) {
		employeeRepository.save(employee);
		return 1L;
	}
	
	// 更新员工
	@Override
	public Long updateEmp(Employee employee) {
		employeeRepository.save(employee);
		return 1L;
	}

	// 使用ID查找员工
	@Override
	public Employee getEmpById(Long id) {
		Employee employee=employeeRepository.findOne(id);
		return employee;
	}

	// 查找所有员工
	@Override
	public List<Employee> getAllEmp() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	// 删除所有员工
	@Override
	public void deleteAllEmp() {
		employeeRepository.deleteAll();
	}

	// 用id删除员工
	@Override
	public void deleteEmpById(Long id) {
		employeeRepository.delete(id);
	}
	
	// 删除选定员工
	@Override
	public void deleteEmpByIds(List<Long> ids) {
		employeeRepository.deteleByIds(ids);
	}


	//查询总记录数
	public int getRecordCount() {
		System.out.println("查询总记录数");
		int recordCount;
		List<Employee> empList = employeeRepository.findAll();
		if (empList.size()>0) {
			recordCount=empList.size();
			return recordCount;
		}
		return 0;
	}
	// 分页
	public List<Employee> getEmpByPage( int firstRow,  int rowCount){
		
		return employeeRepository.findEmployeeByPage(firstRow, rowCount);
	}
	
	
	
	
	@Override
	public Page<Employee> getEmpPage(Pageable pageable) {
		System.out.println("分页开始");
		Page<Employee> empPage=employeeRepository.findAll(pageable);
		System.out.println("分页完成");
		return empPage;
	}

}
