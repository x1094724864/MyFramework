package com.lx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lx.entity.Users;

public interface IUsersService {
	// 创建用户
	public Long createUsers(Users users);

	// 修改用户
	public Long modifyUsers(Users user);

	// 删除用户
	public void removeUsers(Long id);

	//删除选定用户
	public void removeUsersByIds(List<Long> ids);
	
	// 获取用户
	public Users getUsers(Long id);

	// 获取所有用户
	public List<Users> getUsersList();

	// 用户分页
	public List<Users> getUsersPage(Pageable pageable);
	
}