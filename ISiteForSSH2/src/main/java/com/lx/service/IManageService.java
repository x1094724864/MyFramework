package com.lx.service;

import java.util.List;

import com.lx.entity.ManageUsers;

public interface IManageService {
	// 创建管理用户
	public Long createManageUsers(ManageUsers manageUsers);

	// 修改管理用户
	public Long modifyManageUsers(ManageUsers manageUsers);

	// 删除管理用户
	public void removeManageUsers(Long id);

	// 获取管理用户
	public ManageUsers getManageUsers(Long id);
	
	//获取所有管理用户
	public List<ManageUsers> getManageUsersList(ManageUsers manageUsers);
}
