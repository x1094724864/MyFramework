package com.lx.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lx.entity.Department;
import com.lx.entity.Employee;
@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// 更新并保存部门
	<S extends Employee> S save(S employee);

	// 根据ID查找制定部门
	@Query(value = "SELECT * FROM employee_info WHERE id = ?1", nativeQuery = true)
	Employee findOne(Long id);

	// 查找所有部门
	@Query(value = "select * from employee_info", nativeQuery = true)
	List<Employee> findAll();

	// 删除部门
	void delete(Employee employee);

	// 删除所有部门

	void deleteAll();

	// 删除指定ID的部门
	void delete(Long id);

	// 根据姓名查找
	List<Employee> findByName(String name);

	// 根据部门查找
	List<Employee> findByDepartmentName(String departmentName);

	
	//根据部门外键查找员工
	@Query(value = "SELECT * FROM employee_info where department_id=?1", nativeQuery = true)
	List<Employee> findByDepartment(Long id);
	
	
	// 删除选定ID
	@Modifying
	@Query(value = "delete from employee_info where id in (?1)", nativeQuery = true)
	public int deteleByIds(List<Long> ids);
	
	
	//分页
	@Query(value = "SELECT * FROM employee_info Limit ?1,?2", nativeQuery = true)
	List<Employee> findEmployeeByPage(int firstRow,  int rowCount);
	
	Page<Employee> findAll(Pageable pageable);
	
}
