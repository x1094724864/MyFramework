package com.lx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emp_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// 数据库的主键ID
	private Long employee_id;// 员工编号
	private String name;// 员工姓名
	private String address;// 地址
	private Long tel_number;// 电话号码
	private Boolean gender;// 性别
	private String department;// 部门
	private String profession;// 专业
	private Date entry_Time; // 入职时间
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_id=" + employee_id + ", name=" + name + ", address=" + address
				+ ", tel_number=" + tel_number + ", gender=" + gender + ", department=" + department + ", profession="
				+ profession + ", entry_Time=" + entry_Time + "]";
	}

}
