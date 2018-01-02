package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.dao.impl.ManagesDaoImpl;
import com.lx.entity.ManageUsers;
import com.lx.service.IManageService;

@Service
public class ManageServiceImpl implements IManageService {

	@Autowired
	private ManagesDaoImpl ManagesDao;

	public Long createManageUsers(ManageUsers manageUsers) {
		return ManagesDao.insert(manageUsers);
	}

	public Long modifyManageUsers(ManageUsers manageUsers) {
		return ManagesDao.update(manageUsers);
	}

	public void removeManageUsers(Long id) {
		ManagesDao.deleteById(id);
	}

	public ManageUsers getManageUsers(Long id) {
		ManageUsers manageUsers = ManagesDao.get(id);
		return manageUsers;
	}

	public List<ManageUsers> getManageUsersList(ManageUsers manageUsers) {
		List<ManageUsers> manageUsersList = ManagesDao.getManageUsersList(manageUsers);
		return manageUsersList;
	}

}
