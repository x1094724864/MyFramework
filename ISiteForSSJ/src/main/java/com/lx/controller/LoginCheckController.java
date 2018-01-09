package com.lx.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
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

	// 验证码获取
	@RequestMapping(value = "/getYzm", method = RequestMethod.GET)
	public void getYzm(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");

			// 生成随机字串
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
			// 存入会话session
			HttpSession session = request.getSession(true);
			session.setAttribute("_code", verifyCode.toLowerCase());
			// 生成图片
			int w = 120, h = 50;
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
			logger.info(verifyCode.toLowerCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//又是验证码
//	@RequestMapping("authCode")
//    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
//            throws IOException {
//        int width = 63;
//        int height = 37;
//        Random random = new Random();
//        //设置response头信息
//        //禁止缓存
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//
//        //生成缓冲区image类
//        BufferedImage image = new BufferedImage(width, height, 1);
//        //产生image类的Graphics用于绘制操作
//        Graphics g = image.getGraphics();
//        //Graphics类的样式
//        g.setColor(this.getRandColor(200, 250));
//        g.setFont(new Font("Times New Roman",0,28));
//        g.fillRect(0, 0, width, height);
//        //绘制干扰线
//        for(int i=0;i<40;i++){
//            g.setColor(this.getRandColor(130, 200));
//            int x = random.nextInt(width);
//            int y = random.nextInt(height);
//            int x1 = random.nextInt(12);
//            int y1 = random.nextInt(12);
//            g.drawLine(x, y, x + x1, y + y1);
//        }
//
//        //绘制字符
//        String strCode = "";
//        for(int i=0;i<4;i++){
//            String rand = String.valueOf(random.nextInt(10));
//            strCode = strCode + rand;
//            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
//            g.drawString(rand, 13*i+6, 28);
//        }
//        //将字符保存到session中用于前端的验证
//        session.setAttribute("strCode", strCode);
//        g.dispose();
//
//        ImageIO.write(image, "JPEG", response.getOutputStream());
//        response.getOutputStream().flush();
//
//    }
//	
//	//创建颜色
//    Color getRandColor(int fc,int bc){
//        Random random = new Random();
//        if(fc>255)
//            fc = 255;
//        if(bc>255)
//            bc = 255;
//        int r = fc + random.nextInt(bc - fc);
//        int g = fc + random.nextInt(bc - fc);
//        int b = fc + random.nextInt(bc - fc);
//        return new Color(r,g,b);
//    }
	
	
	// 进入主页
	@RequestMapping("home")
	private ModelAndView toHome(HttpServletRequest request, HttpSession session, Users user) {
		mView.setViewName("home/home");
		if (flag(request)) {
			String username = user.getUsername();
			String password = user.getPassword();
			Users user1 = usersServiceImpl.getUsersByNameAndPass(username, password).get(0);
			int permission = user1.getPermission();
			// mView.addObject("user", user1);
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
