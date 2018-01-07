package com.lx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_info")
// 管理员用户
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	public static final int READ_ONLY = 0;// 只读权限
	public static final int MODIFY = 1;// 修改权限
	public static final int SUPERADMIN = 2;// 超级权限
	private int permission;
	@Transient
	private String permissionName;

	// public String getPermission() {
	// return permission;
	// }

/*	public void setPermission(int permission) {
		if (permission == 2) {
			this.permissionName = "高级管理";
		} else if (permission == 1) {
			this.permissionName = "普通管理";
		} else {
			this.permissionName = "普通用户";
		}
	}*/

	public String getPermissionName() {
		if (permission == 2) {
			this.permissionName = "高级管理";
		} else if (permission == 1) {
			this.permissionName = "普通管理";
		} else {
			this.permissionName = "普通用户";
		}
		return permissionName;
	}

	public Users(Long id) {
		super();
		this.id = id;
	}

	public Users() {
		super();
	}
}
