package com.lx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lx.entity.Users;

public class RequestInterceptor1 extends HandlerInterceptorAdapter {

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("权限拦截器1------------" + request.getRequestURI());
		
		 String username = (String) request.getSession().getAttribute("username");
		 Integer permission=  (Integer) request.getSession().getAttribute("permission");
//		 int permission=(int) request.getSession().getAttribute("permission");
//		Users user = (Users) request.getSession().getAttribute("user");
		 System.err.println(request.getContextPath() );
		if (request.getRequestURI().startsWith(request.getContextPath() + "/employee/")
				|| request.getRequestURI().startsWith(request.getContextPath() + "/department/")) {
		/*	if (username == null || !username.equals("admin")) {
				System.out.println("username=" + username + "------return false");
				response.sendRedirect(request.getContextPath() + "/errors/error"); // 返回提示页面
				return false;
			}*/
//			String username = user.getUsername();
		
			if (permission==0) {
				System.out.println("permission=" + permission + "------return false");
				response.sendRedirect(request.getContextPath() + "/error"); // 返回提示页面
				return false;
				
			}
			
			
		}
//		System.out.println("username=" + username + "------return true");
		// return false;
		return true;
		// if(request.getRequestURI().startsWith(request.getContextPath() + "/api/")) {
		// response.sendRedirect(request.getContextPath() + "/index"); // 返回提示页面
		//// request.getRequestDispatcher("index").forward(request, response);
		// return false;
		//// return true;
		// }
		// return true;
	}

	public boolean flag(HttpServletRequest request) {

		boolean employeePath1 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/saveEmp");// 保存员工
		boolean employeePath2 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/editEmp");// 编辑员工
		boolean employeePath3 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/deleteEmp");// 删除员工
		// boolean employeePath4 =
		// request.getRequestURI().startsWith(request.getContextPath() + "/employee/");
		boolean departmentPath1 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/saveDepart");// 保存部门
		boolean departmentPath2 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/editDepart");// 编辑部门
		boolean departmentPath3 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/deleteDepart");// 删除部门
		// boolean departmentPath4 =
		// request.getRequestURI().startsWith(request.getContextPath() +
		// "/department/");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
