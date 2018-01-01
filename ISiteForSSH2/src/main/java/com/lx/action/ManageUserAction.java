package com.lx.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.lx.entity.ManageUsers;
import com.lx.service.impl.ManageServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1240019890883087622L;
	@Autowired
	private ManageServiceImpl manageServiceImpl;

	ManageUsers manageUsers=new ManageUsers();
	public ManageUsers getManageUsers() {
		return manageUsers;
	}

	public void setManageUsers(ManageUsers manageUsers) {
		this.manageUsers = manageUsers;
	}
	
	public String saveMag() {
		manageServiceImpl.createManageUsers(manageUsers);
		return "save";
	}
	
	
	
}
