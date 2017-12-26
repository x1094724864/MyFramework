package com.lx.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.lx.entity.Department;
import com.lx.utils.GetSession;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Repository
public class DepartDao extends HibernateDaoSupport {
	@Autowired
	private GetSession session;

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * private GetSession getCurrentSession() { return
	 * sessionFactory.getCurrentSession(); }
	 */

	// 插入数据
	public Long insert(Department department) {
		return (Long) session.getSession().save(department);
	}

	// 更新数据
	public Long update(Department department) {
		session.getSession().update(department);
		return 1L;
	}

	// 删除数据
	public Long delete(Long id) {
		session.getSession().delete(new Department(id));
		return 1L;
	}

	// 获取数据
	public Department getDepart(Long id) {
		return (Department) session.getSession().get(Department.class, id);
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
		/*不提供 描述属性 查询
		 * if (StringUtils.isNotBlank(department.getDepartment_desc())) { hql +=
		 * " and department_desc = :department_desc"; }
		 */
		if (department.getDepartment_num() != null) {
			hql += " and department_num = :department_num";
		}
		Query query = this.currentSession().createQuery(hql);

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
		List<Department> list = (List<Department>) c.list();
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
