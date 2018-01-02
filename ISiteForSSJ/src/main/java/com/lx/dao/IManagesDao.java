package com.lx.dao;

import java.util.List;

import com.lx.entity.ManageUsers;

public interface IManagesDao {
	// 插入用户
	public Long insert(ManageUsers manageUsers);

	// 更新用户
	public Long update(ManageUsers manageUsers);

	// 删除用户
	public Long deleteById(Long id);

	// 删除选中用户
	public void deleteAllByIds(String[] ids);

	// 获取用户实体
	public ManageUsers get(Long id);

	// 获取所有用户列表
	public List<ManageUsers> getManageUsersList(ManageUsers manageUsers);

}
