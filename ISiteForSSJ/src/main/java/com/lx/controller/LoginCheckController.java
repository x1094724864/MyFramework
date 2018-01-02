package com.lx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.ManageUsers;
@Controller
public class LoginCheckController {
	private ModelAndView mView = new ModelAndView();
	
	@RequestMapping("depart_list")
	public ModelAndView listDepart() {
		
		mView.setViewName("department/depart_list");
		return mView;
	}
	//点击登陆
	@RequestMapping("login")
	private ModelAndView toLogin() {
//		ModelAndView mView = new ModelAndView();
		System.out.println("进入登陆页面！");
		mView.setViewName("login/sign_in");
		return mView;
	}	
	//进入主页
	@RequestMapping("home")
	private ModelAndView toHome(HttpSession session, ManageUsers manageUsers) {
//		ModelAndView mView = new ModelAndView();
		String username=manageUsers.getName();
		String password=manageUsers.getPassword();
		/*if (flag(username, password)) {
			session.setAttribute("username", username);
			boolean flag = username.equals(null) || "".equals(username);
			session.setAttribute("flag", flag);
			System.out.println(session.getAttribute("username"));
			System.out.println(session.getAttribute("flag"));
			return toLoginSuccess();
		}*/
		
		System.out.println("进入主页面！");
		mView.setViewName("home/home");
		return mView;
	}	
	@RequestMapping("home_top")
	private ModelAndView toHome_top() {
//		ModelAndView mView = new ModelAndView();
		System.out.println("进入上页面！");
		mView.setViewName("home/home_top");
		return mView;
	}	
	@RequestMapping("home_left")
	private ModelAndView toHome_left() {
//		ModelAndView mView = new ModelAndView();
		System.out.println("进入左页面！");
		mView.setViewName("home/home_left");
		return mView;
	}	
	
	
	
	
}
