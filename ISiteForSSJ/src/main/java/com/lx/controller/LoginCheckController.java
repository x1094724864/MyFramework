package com.lx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Users;
import com.lx.service.impl.UsersServiceImpl;
@Controller
public class LoginCheckController {
	@Autowired 
	private UsersServiceImpl usersServiceImpl;
	
	
	private ModelAndView mView = new ModelAndView();
	private Users user=new Users();
	
	
	@RequestMapping("depart_list")
	public ModelAndView listDepart() {
		
		mView.setViewName("department/depart_list");
		return mView;
	}
	
	public boolean flag(HttpServletRequest request) {
		// 获取请求中的 username
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 用户名设为username
		user.setUsername(username);
		user.setPassword(password);
		// 精准获取用户名
		List<Users> list = usersServiceImpl.getUsersByNameAndPass(username, password);
		if (list.size() > 0) {
			return true; // 表示有用户
		}
		return false; // 表示无用户
	}
	
	
	
	
	//点击登陆
	@RequestMapping("tosign_in")
	private ModelAndView toSign_in() {
		System.out.println("进入登陆页面！");
		mView.setViewName("login/sign_in");
		return mView;
	}	
	//点击登陆
	@RequestMapping("tosign_up")
	private ModelAndView toSign_up() {
		System.out.println("进入注册页面！");
		mView.setViewName("login/sign_up");
		return mView;
	}	
	//点击注销
	@RequestMapping("tologout")
	private String toLogout(HttpSession session) {
		System.out.println("进入注销页面！");
		session.invalidate();
//		mView.setViewName("login/sign_up");
		return "redirect:home";
	}	
	
	
	
	
	//进入主页
	@RequestMapping("home")
	private ModelAndView toHome(HttpServletRequest request,HttpSession session, Users user) {
		String username=user.getUsername();
		String password=user.getPassword();
		mView.setViewName("home/home");
		if (flag(request)) {
			session.setAttribute("username", username);
			boolean flag = username.equals(null) || "".equals(username);
			session.setAttribute("flag", flag);
			System.out.println(session.getAttribute("username"));
			System.out.println(session.getAttribute("flag"));
			System.out.println("进入主页面！");
			return mView;
		}
		
//		System.out.println("登录失败，进入登录页面！");
//		return toSign_in();
		System.out.println("登录失败，游客身份进入主页面！");
		return mView;
	}	
	@RequestMapping("home_top")
	private ModelAndView toHome_top() {
		System.out.println("进入上页面！");
		mView.setViewName("home/home_top");
		return mView;
	}	
	@RequestMapping("home_left")
	private ModelAndView toHome_left() {
		System.out.println("进入左页面！");
		mView.setViewName("home/home_left");
		return mView;
	}	
	
	
	
	
}
