package com.lx.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.lx.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class EmployeeVo {
	private Long id; // 数据库的主键ID
	private Long employee_id; // 员工编号
	private String name; // 员工姓名
	private Integer age; // 年龄
	private String address; // 地址
	private Long tel_number; // 电话号码
	private String mail; // 邮箱

	private String gender; // 性别
	private Department department;

//	public MultipartFile getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(MultipartFile photo) {
//		this.photo = photo;
//	}

	private String departmentName; // 部门
	private String education; // 学历
	private String profession; // 专业
	private Date entry_Time; // 入职时间
	private MultipartFile photo; // 不保存到数据库
	private String photoName; // 头像(只保存图片名称)

	public EmployeeVo(Long id) {
		super();
		this.id = id;
	}

	public EmployeeVo() {
		super();
	}
}
