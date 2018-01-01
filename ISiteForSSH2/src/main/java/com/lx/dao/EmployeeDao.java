package com.lx.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.utils.GetSession;

@Repository
public class EmployeeDao {
	@Autowired
	private GetSession session;

	// @Autowired
	// private SessionFactory sessionFactory;
	//
	// private Session getCurrentSession() {
	// return sessionFactory.getCurrentSession();
	// }

	// 插入数据
	public Long insert(Employee employee) {
		// Long department_id = (Long) employee.getDepartment_id();
		// Department department=de;
		// if (department_id==null) {
		// employee.getDepartment()
		// }

		return (Long) session.getSession().save(employee);
	}

	// 更新数据
	public Long update(Employee employee) {
		session.getSession().update(employee);
		return 1L;
	}

	// 删除数据
	public Long delete(Long id) {
		Employee employee = getEmployee(id);
		session.getSession().delete(employee);
		return 1L;
	}

	// 删除所选数据

	public void deleteAll(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.parseLong(ids[i]);
			delete(id);
		}
	}

	// 获取数据
	public Employee getEmployee(Long id) {
		return (Employee) session.getSession().get(Employee.class, id);
	}

	// 获取所有员工
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList(Employee employee) {

		String hql = "from employee_info where 1 = 1";
		// 按照id查询
		if (employee.getId() != null) {
			hql += " and ID = :id";
		}
		// 按照员工编号查询
		if (employee.getEmployee_id() != null) {
			hql += " and employee_id = :employee_id";
		}
		// 按照姓名查询
		if (StringUtils.isNotBlank(employee.getName())) {
			hql += " and name like :name";
		}
		// 按照电话号码查询
		if (employee.getTel_number() != null) {
			hql += " and tel_number = :tel_number";
		}
		// 按照学历查询
		if (employee.getEducation() != null) {
			hql += " and education = :education";
		}
		// 按照专业查询
		if (StringUtils.isNotBlank(employee.getProfession())) {
			hql += " and address like :address";
		}
		// 按照部门查询
		if (!employee.getDepartment_name().equals(null)) {
			hql += " and department_name like :department_name";
		}
		Query query = session.getSession().createQuery(hql);

		if (employee.getId() != null) {
			query.setLong("id", employee.getId());
		}
		// 编号查询
		if (employee.getEmployee_id() != null) {
			query.setLong("employee_id", employee.getEmployee_id());
		}
		// 姓名查询
		if (StringUtils.isNotBlank(employee.getName())) {
			query.setString("name", "%" + employee.getName() + "%");
		}
		// 学历查询
		if (StringUtils.isNotBlank(employee.getEducation())) {
			query.setString("education", employee.getEducation());
		}
		// 专业查询
		if (StringUtils.isNotBlank(employee.getProfession())) {
			query.setString("profession", "%" + employee.getProfession() + "%");
		}

		// 按照部门查询
		if (!employee.getDepartment_name().equals(null)) {
			hql += " and department_name like :department_name";
		}

		List<Employee> employeeList = (List<Employee>) query.list();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public int getEmployeeCount(Employee employee) {
		Criteria criteria = session.getSession().createCriteria(Employee.class);
		if (employee.getId() != null) {
			criteria.add(Restrictions.eq("id", employee.getId()));
		}
		// 获取编号
		if (employee.getEmployee_id() != null) {
			criteria.add(Restrictions.eq("employee", employee.getEmployee_id()));
		}
		// 获取姓名
		if (StringUtils.isNotBlank(employee.getName())) {
			criteria.add(Restrictions.like("name", employee.getName(), MatchMode.ANYWHERE));
		}
		// 获取学历
		if (employee.getEducation() != null) {
			criteria.add(Restrictions.eq("education", employee.getEducation()));
		}
		// 获取专业
		if (StringUtils.isNotBlank(employee.getProfession())) {
			criteria.add(Restrictions.like("profession", employee.getProfession()));
		}

		// 获取部门
		/*
		 * if (!employee.getDepartment().equals(null)) {
		 * criteria.add(Restrictions.eq("department", employee.getDepartment())); }
		 */
		List<Department> list = (List<Department>) criteria.list();
		if (list != null && list.size() > 0) {
			return list.size();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeePaginatedList(Employee employee, int first, int count) {
		Criteria criteria = session.getSession().createCriteria(Employee.class);
		if (employee.getId() != null) {
			criteria.add(Restrictions.eq("id", employee.getId()));
		}
		// 编号
		if (employee.getEmployee_id() != null) {
			criteria.add(Restrictions.eq("employee_id", employee.getEmployee_id()));
		}
		// 学历
		if (employee.getEducation() != null) {
			criteria.add(Restrictions.eq("education", employee.getEducation()));
		}

		// 获取姓名
		if (StringUtils.isNotBlank(employee.getName())) {
			criteria.add(Restrictions.like("name", employee.getName(), MatchMode.ANYWHERE));
		}
		// 获取专业
		if (StringUtils.isNotBlank(employee.getProfession())) {
			criteria.add(Restrictions.like("profession", employee.getProfession()));
		}

		// 获取部门
		/*
		 * if (!employee.getDepartment().equals(null)) {
		 * criteria.add(Restrictions.eq("department", employee.getDepartment())); }
		 */

		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return (List<Employee>) criteria.list();

	}
}
