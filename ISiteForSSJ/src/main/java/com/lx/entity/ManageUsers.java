package com.lx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "manageuser_info")
//管理员用户
public class ManageUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;

	public ManageUsers(Long id) {
		super();
		this.id = id;
	}

	public ManageUsers() {
		super();
	}
}
