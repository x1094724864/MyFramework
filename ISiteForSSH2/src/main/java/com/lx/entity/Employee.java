package com.lx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "entity emp")
@Table(name = "emp_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// 数据库的主键ID
	private Long employee_id;// 员工编号
	private String name;// 员工姓名
	private String address;// 地址
	private Long tel_number;// 电话号码
	private String gender;// 性别
//	@ManyToOne(targetEntity = Department.class)
//	@JoinColumn(name = "department_id") // 外键
//	private Long department_id;// 部门
	
	private String department_name;// 部门
	private String education;// 学历
	private String profession;// 专业
	@Temporal(TemporalType.DATE)
	private Date entry_Time; // 入职时间


	public Employee(Long id) {
		super();
		this.id = id;
	}

	public Employee() {
		super();
	}


}
