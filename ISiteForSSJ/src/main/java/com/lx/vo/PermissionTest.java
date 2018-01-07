package com.lx.vo;

import javax.persistence.Embeddable;

@Embeddable
public enum PermissionTest {

	普通用户(0), 高级用户(1), 超级用户(3);
	private int permission; // 成员变量

	private PermissionTest(int permission) { // 构造方法
		this.permission = permission;
	}

	// 普通方法
	public int getPermission() {
		return permission;
	}
}
