package com.lx.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lx.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	// 更新并保存部门
	<S extends Users> S save(S users);

	// 根据ID查找制定部门
	// @Query(value = "SELECT * FROM employee_info WHERE id = ?1", nativeQuery =
	// true)
	Users findOne(Long id);

	// 查找所有部门
	// @Query(value = "select * from employee_info", nativeQuery = true)
	List<Users> findAll();

	// 删除部门
	void delete(Users users);

	// 删除所有部门

	void deleteAll();

	// 删除指定ID的部门
	void delete(Long id);

	// 根据姓名查找
	List<Users> findByUsername(String username);

	// 根据用户名和密码获取用户
	List<Users> findByUsernameAndPassword(String username, String password);

	// 删除选定ID
	@Modifying
	@Query(value = "delete from user_info where id in (?1)", nativeQuery = true)
	public int deteleByIds(List<Long> ids);

	// 根据权限等级查找
	@Query(value = "select * from user_info where permission <= ?1", nativeQuery = true)
	List<Users> findByPermission(Integer permission);
	
	// 根据权限等级分页查找
	@Query(value = "select * from user_info where permission <= ?1  Limit ?2,?3", nativeQuery = true)
	List<Users> findByPermission(Integer permission,int page, int size);
	// 分页
	@Query(value = "SELECT * FROM user_info Limit ?1,?2", nativeQuery = true)
	List<Users> findUsersByPage(int page, int size);

	Page<Users> findAll(Pageable pageable);

	Page<Users> findAllByUsername(String username, Pageable pageable);
}
