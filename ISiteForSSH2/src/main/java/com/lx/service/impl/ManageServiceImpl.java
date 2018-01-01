package com.lx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lx.dao.impl.ManagesDaoImpl;
import com.lx.entity.ManageUsers;
import com.lx.service.IManageService;

@Service
@Transactional
public class ManageServiceImpl implements IManageService {

	@Autowired
	private ManagesDaoImpl ManagesDao;

	@Override
	public Long createManageUsers(ManageUsers manageUsers) {
		// TODO Auto-generated method stub

		return ManagesDao.insert(manageUsers);
	}

	@Override
	public Long modifyManageUsers(ManageUsers manageUsers) {
		// TODO Auto-generated method stub

		return ManagesDao.update(manageUsers);
	}

	@Override
	public void removeManageUsers(Long id) {
		// TODO Auto-generated method stub
		ManagesDao.deleteById(id);

	}

	@Override
	public ManageUsers getManageUsers(Long id) {
		// TODO Auto-generated method stub

		ManageUsers manageUsers = ManagesDao.get(id);
		return manageUsers;
	}

	@Override
	public List<ManageUsers> getManageUsersList(ManageUsers manageUsers) {
		// TODO Auto-generated method stub

		List<ManageUsers> manageUsersList = ManagesDao.getManageUsersList(manageUsers);
		return manageUsersList;
	}

}
