package com.lx.action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.lx.dao.impl.ManagesDaoImpl;
import com.lx.entity.ManageUsers;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2714323596099742439L;
	@Autowired
	private ManagesDaoImpl managesDaoImpl;

	ManageUsers manageUsers = new ManageUsers();

	public ManageUsers getManageUsers() {
		return manageUsers;
	}

	public void setManageUsers(ManageUsers manageUsers) {
		this.manageUsers = manageUsers;
	}

	public boolean Flag() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取请求中的 username
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 用户名设为username
		manageUsers.setName(username);
		manageUsers.setPassword(password);
		// 精准获取用户名
		List<ManageUsers> list = managesDaoImpl.getManageUsersList(manageUsers);
		if (list.size() > 0) {
			return true; // 表示有用户
		}
		return false; // 表示无用户
	}

	public String Login() {

		if (Flag()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("username", request.getParameter("username"));
			// boolean flag = true;
			boolean flag = false;
			request.getSession().setAttribute("flag", flag);
			return "login";
		}

		return "login_page";
	}

	// 跳转到登录页面
	public String toLoginPage() {

		return "login_page";
	}

	// 注销页面
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return "logouted";
	}
}
