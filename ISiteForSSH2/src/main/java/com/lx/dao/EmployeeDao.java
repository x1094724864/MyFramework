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
import org.springframework.stereotype.Repository;

import com.lx.entity.Department;
import com.lx.entity.Employee;

@Repository
public class EmployeeDao {
	// @Autowired
	// private GetSession session;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// 插入数据
	public Long insert(Employee employee) {
		// return (Long) session.getSession().save(employee);
		return (Long) this.getCurrentSession().save(employee);
	}

	// 更新数据
	public Long update(Employee employee) {
		// session.getSession().update(employee);
		this.getCurrentSession().update(employee);
		return 1L;
	}

	// 删除数据
	public Long delete(Long id) {
		// session.getSession().delete(new Employee(id));
		this.getCurrentSession().delete(new Employee(id));
		return 1L;
	}

	// 删除所选数据

	public void deleteAll(String[] ids) {
		// List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.parseLong(ids[i]);
			delete(id);
		}
	}

	// 获取数据
	public Employee getEmployee(Long id) {
		// return (Employee) session.getSession().get(Employee.class, id);
		return (Employee) this.getCurrentSession().get(Employee.class, id);
	}

	// 获取所有员工
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList(Employee employee) {

		String hql = "from employee_info where 1 = 1";
		if (employee.getId() != null) {// 按照id查询
			hql += " and ID = :id";
		}
	/*	if (employee.getEmployee_id() != null) {// 按照员工编号查询
			hql += " and employee_id = :employee_id";
		}
		if (StringUtils.isNotBlank(employee.getName())) {// 按照姓名查询
			hql += " and name like :name";
		}
		if (employee.getTel_number() != null) {// 按照电话号码查询
			hql += " and tel_number = :tel_number";
		}
		if (employee.getEducation() != null) {// 按照学历查询
			hql += " and education = :education";
		}
		if (StringUtils.isNotBlank(employee.getProfession())) {// 按照专业查询
			hql += " and address like :address";
		}
		if (!employee.getDepartment().equals(null)) {// 按照部门查询
			hql += " and department like :department";
		}
*/
		Query query = this.getCurrentSession().createQuery(hql);
		// Query query = session.getSession().createQuery(hql);

	/*	if (employee.getId() != null) {
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
		if (employee.getEducation() != null) {
			query.setInteger("education", employee.getEducation());
		}
		// 专业查询
		if (StringUtils.isNotBlank(employee.getProfession())) {
			query.setString("profession", "%" + employee.getProfession() + "%");
		}*/
		// 按照部门查询
		/*
		 * if (!employee.getDepartment().equals(null)) { hql +=
		 * " and department like :department"; }
		 */

		List<Employee> employeeList = (List<Employee>) query.list();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public int getEmployeeCount(Employee employee) {
		Criteria criteria = this.getCurrentSession().createCriteria(Employee.class);
		// Criteria criteria = session.getSession().createCriteria(Employee.class);
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
		/*if (!employee.getDepartment().equals(null)) {
			criteria.add(Restrictions.eq("department", employee.getDepartment()));
		}*/
		List<Department> list = (List<Department>) criteria.list();
		if (list != null && list.size() > 0) {
			return list.size();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeePaginatedList(Employee employee, int first, int count) {
		Criteria criteria = this.getCurrentSession().createCriteria(Employee.class);
		// Criteria criteria = session.getSession().createCriteria(Employee.class);
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
		/*if (!employee.getDepartment().equals(null)) {
			criteria.add(Restrictions.eq("department", employee.getDepartment()));
		}*/

		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return (List<Employee>) criteria.list();

	}
}
