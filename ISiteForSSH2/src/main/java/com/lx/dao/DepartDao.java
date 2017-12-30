package com.lx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.lx.entity.Department;
import com.lx.utils.GetSession;

@Repository
public class DepartDao extends HibernateDaoSupport {
	@Autowired
	private GetSession session;

	// @Autowired private SessionFactory sessionFactory;
	//
	// private Session getCurrentSession() { return
	// sessionFactory.getCurrentSession(); }
	//

	// 插入数据
	public Long insert(Department department) {
		return (Long) session.getSession().save(department);
		// return (Long) this.getCurrentSession().save(department);
	}

	// 更新数据
	public Long update(Department department) {
		session.getSession().update(department);
		// this.getCurrentSession().update(department);
		return 1L;
	}

	// 删除数据
	public Long delete(Long id) {
		Department department = getDepart(id);
		session.getSession().delete(department);
		// this.getCurrentSession().delete(department);
		// session.getSession().delete(id);
		return 1L;
	}

	// 删除所有选定数据
	public void deleteAll(String[] ids) {

		String idString = "";
		for (int i = 0; i < ids.length - 1; i++) {
			// Long id = Long.parseLong(ids[i]);
			idString = idString + Long.parseLong(ids[i]) + ",";

			// session.getSession().delete(id);
			// delete(id);
		}
		idString = idString + Long.parseLong(ids[ids.length-1]);

		String sql = "delete from department_info where ID in (" + idString + ")";

		session.getSession().beginTransaction();
		session.getSession().createQuery(sql).executeUpdate();

		 session.getSession().close();
	}

	// 获取数据
	public Department getDepart(Long id) {
		return (Department) session.getSession().get(Department.class, id);
		// return (Department) this.getCurrentSession().get(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentList(Department department) {

		// String hql = "from department_info where 1 = 1";
		// if (department.getId() != null) {
		// hql += " and ID = :id";
		// }
		// if (StringUtils.isNotBlank(department.getDepartment_name())) {
		// hql += " and department_name like :department_name";
		// }
		// /*
		// * if (StringUtils.isNotBlank(department.getDepartment_desc())) { hql +=
		// * " and department_desc = :department_desc"; }
		// */
		// if (department.getDepartment_num() != null) {
		// hql += " and department_num = :department_num";
		// }
		// // Query query = this.getCurrentSession().createQuery(hql);
		// Query query = session.getSession().createQuery(hql);
		//
		// if (department.getId() != null) {
		// query.setLong("id", department.getId());
		// }
		// if (StringUtils.isNotBlank(department.getDepartment_name())) {
		// query.setString("department_name", "%" + department.getDepartment_name() +
		// "%");
		// }
		// if (department.getDepartment_num() != null) {
		// query.setInteger("department_num", department.getDepartment_num());
		// }
		// List<Department> departmentList = (List<Department>) query.list();
		Criteria criteria = session.getSession().createCriteria(Department.class);
		if (department.getId() != null) {
			criteria.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			criteria.add(Restrictions.like("name", department.getDepartment_name(), MatchMode.ANYWHERE));
		}
		if (department.getDepartment_num() != null) {
			criteria.add(Restrictions.eq("getDepartment_num", department.getDepartment_num()));
		}

		List<Department> departmentList = criteria.list();
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public int getDepartmentCount(Department department) {
		// Criteria criteria =
		// this.getCurrentSession().createCriteria(Department.class);
		Criteria criteria = session.getSession().createCriteria(Department.class);
		if (department.getId() != null) {
			criteria.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			criteria.add(Restrictions.like("name", department.getDepartment_name(), MatchMode.ANYWHERE));
		}
		if (department.getDepartment_num() != null) {
			criteria.add(Restrictions.eq("getDepartment_num", department.getDepartment_num()));
		}
		List<Department> list = (List<Department>) criteria.list();
		if (list != null && list.size() > 0) {
			return list.size();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	// @Override
	public List<Department> getDepartmentPaginatedList(Department department, int first, int count) {
		Criteria criteria = this.currentSession().createCriteria(Department.class);
		if (department.getId() != null) {
			criteria.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			criteria.add(Restrictions.like("name", department.getDepartment_name(), MatchMode.ANYWHERE));
		}
		if (department.getDepartment_num() != null) {
			criteria.add(Restrictions.eq("getDepartment_num", department.getDepartment_num()));
		}
		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return (List<Department>) criteria.list();

	}
}
