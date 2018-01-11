package com.lx.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lx.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	// 更新并保存部门
	<S extends Department> S save(S department);

	// 根据ID查找制定部门
	@Query(value = "SELECT * FROM department_info WHERE id = ?1", nativeQuery = true)
	Department findOne(Long id);

	// 根据部门名称查找指定部门
	@Query(value = "SELECT * FROM department_info WHERE department_name = ?1", nativeQuery = true)
	List<Department> findByDepartmentName(String departmentName);

	// 根据部门编号查找指定部门
	@Query(value = "SELECT * FROM department_info WHERE department_num = ?1", nativeQuery = true)
	List<Department> findByDepartmentNum(Integer departmentNum);
	
	// 查找所有部门
	@Query(value = "select * from department_info", nativeQuery = true)
	List<Department> findAll();

	// 删除部门
	void delete(Department department);

	// 删除所有部门
	void deleteAll();

	// 删除指定ID的部门
	void delete(Long id);

	// 根据部门名称查找
	// @Query(value = "select * from department_info", nativeQuery = true)
	// List<Department> findBydepartmentName(String departmentName);

	// 删除选定ID
	@Modifying
	@Query(value = "delete from department_info where id in (?1)", nativeQuery = true)
	public int deteleByIds(List<Long> ids);

	@Query(value = "SELECT * FROM department_info Limit ?1,?2", nativeQuery = true)
	List<Department> findDepartmentByPage(int page, int size);

}
