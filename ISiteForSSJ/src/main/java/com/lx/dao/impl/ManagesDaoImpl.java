package com.lx.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.dao.IManagesDao;
import com.lx.entity.ManageUsers;
import com.lx.utils.GetSession;

@Repository
@Transactional
public class ManagesDaoImpl implements IManagesDao {
	@Autowired
	private GetSession session;

	public Long insert(ManageUsers manageUsers) {
		// TODO Auto-generated method stub
		session.getSession().save(manageUsers);

		return 1L;
	}

	public Long update(ManageUsers manageUsers) {
		// TODO Auto-generated method stub
		session.getSession().update(manageUsers);
		return 1L;
	}

	public Long deleteById(Long id) {
		// TODO Auto-generated method stub
		ManageUsers manageUsers = get(id);
		session.getSession().delete(manageUsers);
		return 1L;
	}

	public void deleteAllByIds(String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.parseLong(ids[i]);
			deleteById(id);
		}
	}

	public ManageUsers get(Long id) {
		// TODO Auto-generated method stub
		ManageUsers manageUsers = (ManageUsers) session.getSession().get(getClass(), id);
		return manageUsers;
	}

	@SuppressWarnings("unchecked")
	public List<ManageUsers> getManageUsersList(ManageUsers manageUsers) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getSession().createCriteria(ManageUsers.class);
		if (manageUsers.getId() != null) {
			criteria.add(Restrictions.eq("id", manageUsers.getId()));
		}
		if (StringUtils.isNotBlank(manageUsers.getName())) {
//			criteria.add(Restrictions.like("name", manageUsers.getName(), MatchMode.ANYWHERE));
			criteria.add(Restrictions.eq("name", manageUsers.getName()));
		}
		if (StringUtils.isNotBlank(manageUsers.getPassword())) {
			criteria.add(Restrictions.eq("password", manageUsers.getPassword()));
		}
		List<ManageUsers> manageUsersList = criteria.list();

		return manageUsersList;
	}
}