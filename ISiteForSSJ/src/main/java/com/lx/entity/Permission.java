package com.lx.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Parent;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="permission")
//@Embeddable
@Getter@Setter
public class Permission {
	
	public static final int READ_ONLY = 0;// 只读权限
	public static final int MODIFY = 1;// 修改权限
	public static final int SUPERADMIN = 2;// 超级权限
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="permission")
	private int permission;
//	@Parent
//	private Users owner;
	
	
}
