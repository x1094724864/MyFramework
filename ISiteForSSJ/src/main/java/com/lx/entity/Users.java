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
	private Integer permission;
	@Transient
	private String permissionName;

	private String email;
	// public String getPermission() {
	// return permission;
	// }

	// public void setPermissionName(int permission) {
	// if (permission > 9) {
	// this.permissionName = "超级至尊无敌大管理";
	// } else if (permission == 3) {
	// this.permissionName = "超级管理";
	// } else if (permission == 2) {
	// this.permissionName = "管理用户";
	// } else if (permission == 1) {
	// this.permissionName = "普通用户";
	// } else {
	// this.permissionName = "临时用户";
	// }
	// }

	public String getPermissionName() {

		if (permission > 9) {
			this.permissionName = "超级至尊无敌大管理";
		} else if (permission == 3) {
			this.permissionName = "超级管理";
		} else if (permission == 2) {
			this.permissionName = "管理用户";
		} else if (permission == 1) {
			this.permissionName = "普通用户";
		} else if (permission == 0) {
			this.permissionName = "临时用户";
		} else if (permission == null) {
			this.permissionName = "游客";
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
