package com.lx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Users;
import com.lx.service.impl.UsersServiceImpl;

@Controller
//@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;

	private Users user= new Users();
	
	// 添加用户
	@RequestMapping("saveUser")
	public String createUser(Users user) {
		usersServiceImpl.createUsers(user);
		return "redirect:userList";
	}
	
	// 添加临时用户
	@RequestMapping("temporary")
	public ModelAndView temporaryUser(HttpSession session,Users user) {
		usersServiceImpl.createUsers(user);
		String username = user.getUsername();
//		String password = user.getPassword();
//		Users user1 = usersServiceImpl.getUsersByNameAndPass(username, password).get(0);
		int permission = user.getPermission();
		session.setAttribute("username", username);
		session.setAttribute("permission", permission);
		boolean flag = username.equals(null) || "".equals(username);
		session.setAttribute("flag", flag);
		session.setAttribute("user", user);
		ModelAndView mView=new ModelAndView();
		mView.addObject("user", user);
		mView.setViewName("home/home");
//		return "redirect:home";
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
	public List<Users> getUsersPage() {
		Pageable pageable = new PageRequest(0, 5);
		List<Users> usersPageList = usersServiceImpl.getUsersPage(pageable);
		return (List<Users>) usersPageList;
	}

	
	
	@RequestMapping("users/userList")
	public ModelAndView userList(HttpSession session) {
		ModelAndView mView=new ModelAndView();
		List<Users> usersList = getUsersPage();//分页
//		List<Users> usersList = getUsersList();//不分页
		mView.addObject("usersList", usersList);
		mView.setViewName("users/users_list");
//		return "redirect:home";
		return mView;
	}
	
	
	//返回用户编辑页面
	@RequestMapping("users/editUser")
	public ModelAndView editUser(@RequestParam("id") Long id) {
		user=usersServiceImpl.getUsers(id);
		ModelAndView mView=new ModelAndView();
		mView.addObject("user", user);
		mView.setViewName("users/edit_user");
		return mView;
	}
	
	//进入用户添加页面
	@RequestMapping("users/addUser")
	public ModelAndView addUser() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("users/edit_user");
		return mView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
