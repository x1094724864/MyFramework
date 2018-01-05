package com.lx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lx.entity.Employee;

public interface IEmployeeService {
	// 增加员工
	public Long insertEmp(Employee employee);

	// 更新员工
	Long updateEmp(Employee employee);
	//保存或修改员工
	Long saveOrUpdateEmp(Employee employee);
	// 查找员工
	Employee getEmpById(Long id);

	// 查找所有员工
	List<Employee> getAllEmp();

	// 删除所有员工
	void deleteAllEmp();

	// 删除所选员工
	void deleteEmpByIds(List<Long> ids);

	// 分页
	Page<Employee> getEmpPage(Pageable pageable);

	void deleteEmpById(Long id);

}
