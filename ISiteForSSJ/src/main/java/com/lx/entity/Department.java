package com.lx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "entity depart")
@Table(name = "department_info")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5192658086866005588L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="department_num")
	private Integer departmentNum;// 部门编号

	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="department_name")
	private String departmentName;// 部门名称
	@Column(name = "department_desc", length = 400)
	private String department_desc;// 部门描述

	public Department(Long id) {
		super();
		this.id = id;
	}

	public Department() {
	}

	public Department(Integer departmentNum, String departmentName, String department_desc) {
		super();
		this.departmentNum = departmentNum;
		this.departmentName = departmentName;
		this.department_desc = department_desc;
	}
}
