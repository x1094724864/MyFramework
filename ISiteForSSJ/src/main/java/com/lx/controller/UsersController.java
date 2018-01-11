package com.lx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Users;
import com.lx.service.impl.UsersServiceImpl;
import com.lx.utils.Pager;

@Controller
// @RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	Pager pager = new Pager();
	
	private Users user = new Users();

	// 添加用户
	@RequestMapping("saveUser")
	public String createUser(Users user) {
		usersServiceImpl.createUsers(user);
		return "redirect:userList";
	}

	// 添加临时用户
	@RequestMapping("temporary")
	public ModelAndView temporaryUser(HttpSession session, Users user) {
		usersServiceImpl.createUsers(user);
		String username = user.getUsername();
		// String password = user.getPassword();
		// Users user1 = usersServiceImpl.getUsersByNameAndPass(username,
		// password).get(0);
		int permission = user.getPermission();
		session.setAttribute("username", username);
		session.setAttribute("permission", permission);
		boolean flag = username.equals(null) || "".equals(username);
		session.setAttribute("flag", flag);
		session.setAttribute("user", user);
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
		mView.setViewName("home/home");
		// return "redirect:home";
		return mView;
	}

	// 修改
	@RequestMapping("modifyUser")
	public String modifyUser(Users user) {
		usersServiceImpl.modifyUsers(user);
		return "redirect:users/userList";
	}

	// 删除
	@RequestMapping("users/deleteUser")
	public String deleteUser(Long id) {
		usersServiceImpl.removeUsers(id);
		return "redirect:userList";
	}

	// 查询用户
	public List<Users> getUsersList() {
		List<Users> usersList = usersServiceImpl.getUsersList();
		return usersList;
	}

	// 分页
	public Page<Users> getUsersPage(Integer requestPage) {
		// Pageable pageable =pageRequest;
		Pageable pageable = new PageRequest(requestPage, 8);
		Page<Users> usersPageList = usersServiceImpl.getUsersPage(pageable);
		return usersPageList;
	}

	private List<Users> getUsersWithPage(String requestPage) {
		int recordCount = usersServiceImpl.getRecordCount();
		pager.init(recordCount, pager.getPageSize(), requestPage);
		int firstRow = pager.getFirstRow();
		int rowCount = pager.getRowCount();
		List<Users> usersPageList = usersServiceImpl.getUsersByPage(firstRow, rowCount);
		// request.setAttribute("pager", pager);
		return usersPageList;
	}
	
	
	@RequestMapping("users/userList")
	public ModelAndView userList(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		ModelAndView mView = new ModelAndView();
//		Page<Users> usersPageList = getUsersPage(requestPage);// 分页
//		List<Users> usersList = usersPageList.getContent();
		List<Users> usersList=getUsersWithPage(requestPage);
		mView.addObject("usersList", usersList);
		session.getServletContext().setAttribute("pager", pager);
//		mView.addObject("usersPageList", usersPageList);
		mView.setViewName("users/users_list");
		return mView;
	}

	// 返回用户编辑页面
	@RequestMapping("users/editUser")
	public ModelAndView editUser(@RequestParam("id") Long id) {
		user = usersServiceImpl.getUsers(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
		mView.setViewName("users/edit_user");
		return mView;
	}

	// 进入用户添加页面
	@RequestMapping("users/addUser")
	public ModelAndView addUser() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("users/edit_user");
		return mView;
	}


}
