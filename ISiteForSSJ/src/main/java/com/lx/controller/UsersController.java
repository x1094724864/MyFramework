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

	// 修改
	public void modifyUser(Users user) {
		usersServiceImpl.modifyUsers(user);
	}

	// 删除
	public void deleteUser(Long id) {
		usersServiceImpl.removeUsers(id);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
