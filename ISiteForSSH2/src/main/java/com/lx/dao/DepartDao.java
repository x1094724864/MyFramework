package com.lx.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

	/*@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}*/

	// 插入数据
	public Long insert(Department department) {
		 return (Long) session.getSession().save(department);
//		return (Long) this.getCurrentSession().save(department);
	}

	// 更新数据
	public Long update(Department department) {
		 session.getSession().update(department);
//		this.getCurrentSession().update(department);
		return 1L;
	}

	// 删除数据
	public void delete(Long id) {
		 session.getSession().delete(new Department(id));
//		sessionFactory.openSession().delete(new Department(id));
//		this.getCurrentSession().delete(new Department(id));
//		sessionFactory.getCurrentSession().delete(new Department(id));
//		return 1L;
	}

	// 删除所有选定数据
	public void deleteAll(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.parseLong(ids[i]);
			session.getSession().delete(id);
		}
	}

	// 获取数据
	public Department getDepart(Long id) {
		 return (Department) session.getSession().get(Department.class, id);
//		return (Department) this.getCurrentSession().get(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentList(Department department) {

		String hql = "from department_info where 1 = 1";
		if (department.getId() != null) {
			hql += " and ID = :id";
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			hql += " and department_name like :department_name";
		}
		/*
		 * if (StringUtils.isNotBlank(department.getDepartment_desc())) { hql +=
		 * " and department_desc = :department_desc"; }
		 */
		if (department.getDepartment_num() != null) {
			hql += " and department_num = :department_num";
		}
//		Query query = this.getCurrentSession().createQuery(hql);
		Query query = session.getSession().createQuery(hql);

		if (department.getId() != null) {
			query.setLong("id", department.getId());
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			query.setString("department_name", "%" + department.getDepartment_name() + "%");
		}
		/*
		 * if (StringUtils.isNotBlank(department.getDepartment_desc())) {
		 * query.setString("department_desc", "%" +department.getDepartment_desc() +
		 * "%"); }
		 */
		if (department.getDepartment_num() != null) {
			query.setInteger("department_num", department.getDepartment_num());
		}
		List<Department> departmentList = (List<Department>) query.list();
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public int getDepartmentCount(Department department) {
//		Criteria criteria = this.getCurrentSession().createCriteria(Department.class);
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
		Criteria c = this.currentSession().createCriteria(Department.class);
		if (department.getId() != null) {
			c.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			c.add(Restrictions.like("name", department.getDepartment_name(), MatchMode.ANYWHERE));
		}
		if (department.getDepartment_num() != null) {
			c.add(Restrictions.eq("getDepartment_num", department.getDepartment_num()));
		}
		c.setFirstResult(first);
		c.setMaxResults(count);
		return (List<Department>) c.list();

	}
}
