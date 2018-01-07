package com.lx.service;

import java.util.List;

import com.lx.entity.Users;

public interface IManageService {
	// 创建管理用户
	public Long createManageUsers(Users manageUsers);

	// 修改管理用户
	public Long modifyManageUsers(Users manageUsers);

	// 删除管理用户
	public void removeManageUsers(Long id);

	// 获取管理用户
	public Users getManageUsers(Long id);
	
	//获取所有管理用户
	public List<Users> getManageUsersList(Users manageUsers);
}
