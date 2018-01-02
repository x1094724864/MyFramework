package com.lx.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.entity.Department;
import com.lx.utils.GetSession;

@Repository
@Transactional
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
	}

//	public void saveOrUpdate(Department department) {
//		session.getSession().saveOrUpdate(department);
//	}

	// 更新数据
	public Long update(Department department) {
		session.getSession().update(department);
		return 1L;
	}

	// 删除数据
	public List<String> deleteById(Long id) {
		Department department = getDepart(id);
//		List<Department> list=getDepartmentList(department);
		List<String> department_nameList=new ArrayList<String>();
		department_nameList.add(department.departmentName());
		
		session.getSession().delete(department);
		 return department_nameList;
	}

	// 删除所有选定数据
//	@Transactional
	public void deleteAll(String[] ids) {
		for (int i = 0; i < ids.length ; i++) {
			Long id = Long.parseLong(ids[i]);
			deleteById(id);
		}
	}

	// 获取数据
	public Department getDepart(Long id) {
		Department department= (Department) session.getSession().get(Department.class, id);
		return department;
	}
	
	
	
	//使用部门名称查询部门
	@SuppressWarnings("unchecked")
	public Department getDepartByDepartment_name(String department_name) throws Exception {
		Criteria criteria = session.getSession().createCriteria(Department.class);
		Department department=new Department();
		department.setDepartment_name(department_name);
		if (department.getId() != null) {
			criteria.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			criteria.add(Restrictions.eq("department_name", department.getDepartment_name()));
		}
		List<Department> departmentList = criteria.list();
//		List<Department> departmentList =getDepartmentList(department);
		
//		return departmentList;
		return departmentList.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentList(Department department) {

		Criteria criteria = session.getSession().createCriteria(Department.class);
		if (department.getId() != null) {
			criteria.add(Restrictions.eq("id", department.getId()));
		}
		if (StringUtils.isNotBlank(department.getDepartment_name())) {
			criteria.add(Restrictions.like("department_name", department.getDepartment_name(), MatchMode.ANYWHERE));
		}
		if (department.getDepartment_num() != null) {
			criteria.add(Restrictions.eq("department_num", department.getDepartment_num()));
		}

		List<Department> departmentList = criteria.list();
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public int getDepartmentCount(Department department) {
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
