package com.lx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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

//		String username = (String) request.getSession().getAttribute("username");
		Integer permission = (Integer) request.getSession().getAttribute("permission");
		//加入请求的是增删改等方法，则进行权限判定
		if (permissionRequest(request)) {
			if (permission <=1||permission==null) {
				System.out.println("permission=" + permission + "------return false");
				response.sendRedirect(request.getContextPath() + "/error"); // 返回提示页面
				return false;
			}
			return true;
		}else if (usersManagePermissionRequest(request)) {
			if (permission <3||permission==null) {
				System.out.println("permission=" + permission + "------return false");
				response.sendRedirect(request.getContextPath() + "/error"); // 返回提示页面
				return false;
			}
			return true;
		}
		return true;
	}

	public boolean permissionRequest(HttpServletRequest request) {
		boolean employeePath1 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/saveEmp");// 保存员工
		boolean employeePath2 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/editEmp");// 编辑员工
		boolean employeePath3 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/deleteEmp");// 删除员工
		boolean employeePath4 = request.getRequestURI().startsWith(request.getContextPath() + "/employee/detailsEmp");// 员工详细信息

		boolean departmentPath1 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/saveDepart");// 保存部门
		boolean departmentPath2 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/editDepart");// 编辑部门
		boolean departmentPath3 = request.getRequestURI()
				.startsWith(request.getContextPath() + "/department/deleteDepart");// 删除部门
		//加入请求的是以上方法，返回true
		if (employeePath1 || employeePath2 || employeePath3 ||employeePath4 || departmentPath1 || departmentPath2 || departmentPath3) {
			return true;
		}
		return false;
	}

	public boolean usersManagePermissionRequest(HttpServletRequest request) {
		boolean permissionRequest = request.getRequestURI().startsWith(request.getContextPath() + "/users");// 访问用户管理相关
		//加入请求的是以上方法，返回true
		if (permissionRequest) {
			return true;
		}
		return false;
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
