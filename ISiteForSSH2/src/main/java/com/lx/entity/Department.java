package com.lx.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Entity
// @Table(name = "department_info")
public class Department {
	private Long id;
	private Integer department_num;// 部门编号
	private String department_name;// 部门名称
	private String department_desc;// 部门描述；

	public Department(Long id) {
		super();
		this.id = id;
	}

	public Department() {
	}

	public Department(int department_num, String department_name, String department_desc) {
		super();
		this.department_num = department_num;
		this.department_name = department_name;
		this.department_desc = department_desc;
	}

}
