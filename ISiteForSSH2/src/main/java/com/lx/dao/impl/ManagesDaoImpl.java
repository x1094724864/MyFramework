package com.lx.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
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

	@Override
	public Long insert(ManageUsers manageUsers) {
		// TODO Auto-generated method stub
		session.getSession().save(manageUsers);

		return 1L;
	}

	@Override
	public Long update(ManageUsers manageUsers) {
		// TODO Auto-generated method stub
		session.getSession().update(manageUsers);
		return 1L;
	}

	@Override
	public Long deleteById(Long id) {
		// TODO Auto-generated method stub
		ManageUsers manageUsers = get(id);
		session.getSession().delete(manageUsers);
		return 1L;
	}

	@Override
	public void deleteAllByIds(String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.parseLong(ids[i]);
			deleteById(id);
		}
	}

	@Override
	public ManageUsers get(Long id) {
		// TODO Auto-generated method stub
		ManageUsers manageUsers = (ManageUsers) session.getSession().get(getClass(), id);
		return manageUsers;
	}

	@SuppressWarnings("unchecked")
	@Override
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

		// String hql = "from manageuser_info where 1 = 1";
		// if (manageUsers.getId() != null) {
		// hql += " and id = :id";
		// }
		// //精准匹配姓名
		// if (StringUtils.isNotBlank(manageUsers.getName())) {
		// hql += " and name like :name";
		// }
		// if (StringUtils.isNotBlank(manageUsers.getPassword())) {
		// hql += " and password= :password";
		// }
		// Query query = session.getSession().createQuery(hql);
		//
		// if (manageUsers.getId() != null) {
		// query.setLong("id", manageUsers.getId());
		// }
		// if (StringUtils.isNotBlank(manageUsers.getName())) {
		// query.setString("name", "%" + manageUsers.getName() + "%");
		// }
		//// if (StringUtils.isNotBlank(manageUsers.getPassword())) {
		//// query.setString("pass", manageUsers.getPassword());
		//// }
		// List<ManageUsers> manageUsersList = (List<ManageUsers>) query.list();
		return manageUsersList;
	}
}