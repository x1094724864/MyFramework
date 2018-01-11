package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lx.entity.Department;
import com.lx.entity.Users;
import com.lx.repository.UsersRepository;
import com.lx.service.IUsersService;

@Service
@Transactional
public class UsersServiceImpl implements IUsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Long createUsers(Users users) {
		usersRepository.save(users);
		return 1L;
	}

	@Override
	public Long modifyUsers(Users user) {
		usersRepository.saveAndFlush(user);
		return 1L;
	}

	@Override
	public void removeUsers(Long id) {
		usersRepository.delete(id);
	}

	@Override
	public void removeUsersByIds(List<Long> ids) {
		usersRepository.deteleByIds(ids);
	}

	@Override
	public Users getUsers(Long id) {

		return usersRepository.findOne(id);
	}

	@Override
	public List<Users> getUsersList() {
		return usersRepository.findAll();
	}

	// 根据用户名和密码获取用户
	public List<Users> getUsersByNameAndPass(String username, String password) {
		List<Users> usersList = usersRepository.findByUsernameAndPassword(username, password);
		return usersList;
	}

	// 根据用户名获取用户
	public List<Users> getUsersByName(String username) {
		List<Users> usersList = usersRepository.findByUsername(username);
		return usersList;
	}

	// 获取总记录数
	public int getRecordCount() {
		System.out.println("查询总记录数");
		int recordCount = (int) usersRepository.count();
		return recordCount;
	}

	//分页
	public List<Users> getUsersByPage( int firstRow, int rowCount){
		return usersRepository.findUsersByPage(firstRow, rowCount);
	}
	
	@Override
	public Page<Users> getUsersPage(Pageable pageable) {
		Page<Users> userPageList = usersRepository.findAll(pageable);
		return userPageList;
	}

	// public List<Users> getUsersPageByUsername(String name, Pageable pageable) {
	// List<Users> page =usersRepository.findAllByUsername(name,
	// pageable).getContent();
	// return page;
	// }

}
