package com.lx.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "entity Employee")
@Table(name = "employee_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 							// 数据库的主键ID
	private Long employee_id; 						// 员工编号
	private String name; 						// 员工姓名
	private Integer age; 						// 年龄
	private String address; 					// 地址
	private Long tel_number; 					// 电话号码
	private String mail;						// 邮箱

	private String gender; 						// 性别
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "department_id") 		// 外键
	private Department department;
	@Column(name = "department_name")
	private String departmentName; 				// 部门
	private String education; 					// 学历
	private String profession; 					// 专业
	@Temporal(TemporalType.DATE)
	private Date entry_Time; 					// 入职时间
	@Transient
	private MultipartFile photo; 				// 不保存到数据库
	private String photoName; 					// 头像(只保存图片名称)

	public Employee(Long id) {
		super();
		this.id = id;
	}

	public Employee() {
		super();
	}

//	public MultipartFile getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(MultipartFile photo) {
//		this.photo = photo;
//	}
	
	
	
	// public Long getDepartment_id() {
	// return department_id;
	// }
	//
	// public void setDepartment_id(Department department) {
	// this.department_id = department.getId();
	// }
}
