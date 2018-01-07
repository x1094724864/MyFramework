package com.lx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lx.vo.PermissionTest;

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
	
	@ManyToOne
	@JoinColumn(name = "permission") 
	private Permission permission;	// 用户权限

//	@Enumerated(EnumType.ORDINAL)
//	@Column(name="permission")
//	private PermissionTest permission;
	
	
	public Users(Long id) {
		super();
		this.id = id;
	}

	public Users() {
		super();
	}
}
