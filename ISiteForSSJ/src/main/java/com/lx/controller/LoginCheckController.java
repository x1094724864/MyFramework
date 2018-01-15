package com.lx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Users;
import com.lx.service.impl.UsersServiceImpl;
import com.lx.utils.VerifyCodeUtils;

@Controller
public class LoginCheckController {
	@Autowired
	private UsersServiceImpl usersServiceImpl;

	private static Logger logger = Logger.getLogger(LoginCheckController.class);

	private ModelAndView mView = new ModelAndView();
	private Users user = new Users();

	@RequestMapping("depart_list")
	public ModelAndView listDepart() {

		mView.setViewName("department/depart_list");
		return mView;
	}

	@RequestMapping("checkUsernameAndPassword")
	@ResponseBody
	public boolean checkUsernameAndPassword(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// 用户名设为username
		// 精准获取用户名
		List<Users> list = usersServiceImpl.getUsersByNameAndPass(username, password);
		if (list.size() > 0) {
			user.setUsername(username);
			user.setPassword(password);
			return true; // 表示有用户
		}
		return false; // 表示无用户
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

	@RequestMapping("userIsExist")
	@ResponseBody
	public boolean userIsExist(HttpServletRequest request, @RequestParam("username") String username) {
		// String username = request.getParameter("username");
		List<Users> list = usersServiceImpl.getUsersByName(username);
		if (list.size() > 0) {
			return true; // 表示有用户
		}
		return false; // 表示无用户
	}

	// 点击登陆
	@RequestMapping("/tosign_in")
	private ModelAndView toSign_in() {
		System.out.println("进入登陆页面！");
		mView.setViewName("login/sign_in");
		return mView;
	}

	// 点击注册
	@RequestMapping("tosign_up")
	private ModelAndView toSign_up() {
		System.out.println("进入注册页面！");
		mView.setViewName("login/sign_up");
		return mView;
	}

	// 点击注销
	@RequestMapping("tologout")
	private String toLogout(HttpSession session) {
		System.out.println("进入注销页面！");
		session.invalidate();
		return "redirect:home";
	}

	// 点击重新登录
	@RequestMapping("toRelogin")
	private String toRelogin(HttpSession session) {
		session.invalidate();
		return "redirect:tosign_in";
	}

	
	// 进入主页
	@RequestMapping("home")
	private ModelAndView toHome(HttpServletRequest request, HttpSession session, Users user) {
		mView.setViewName("home/home");
		if (flag(request)) {
			String username = user.getUsername();
			String password = user.getPassword();
			Users user1 = usersServiceImpl.getUsersByNameAndPass(username, password).get(0);
			int permission = user1.getPermission();
			session.setAttribute("user", user1);
			session.setAttribute("username", username);
			session.setAttribute("permission", permission);
			boolean flag = username.equals(null) || "".equals(username);
			session.setAttribute("flag", flag);
			return mView;
		}

		// return toSign_in();
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

	@RequestMapping("home_right")
	private ModelAndView toHome_right(HttpSession session, Users user) {
		System.out.println("进入右页面！");
		user = (Users) session.getAttribute("user");
		// String password = user.getPassword();
		// Users user1 = usersServiceImpl.getUsersByNameAndPass(username,
		// password).get(0);
		// Integer permission= (Integer) session.getAttribute("permission");
		// if (permission==null) {
		// session.setAttribute("permissionName", "游客");
		// }
		mView.addObject("user", user);
		mView.setViewName("home/home_right");
		return mView;
	}

}
