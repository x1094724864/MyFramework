package com.lx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.vo.IConstant;

@Controller
// @RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	private ModelAndView mView = new ModelAndView();

	private void getDepartmentList(HttpSession session) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		session.getServletContext().setAttribute("departmentList", departmentList);
	}

	// 进入部门列表页面
	@RequestMapping("listDepart")
	private ModelAndView listDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/depart_list");
		return mView;
	}

	// 进入部门编辑页面
	@RequestMapping("editDepart")
	private @ResponseBody ModelAndView editDepart(HttpSession session, Long id) {
		Department department = departmentServiceImpl.getDepartById(id);

		mView.addObject("department", department);

		mView.setViewName("department/edit_depart");
		return mView;
	}

	// 进入部门修改页面
	@RequestMapping("modDepart")
	private ModelAndView modDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/mod_depart");
		return mView;
	}

	// 进入部门删除页面
	@RequestMapping("removeDepart")
	private ModelAndView removeDepart(HttpSession session) {
		getDepartmentList(session);
		mView.setViewName("department/remove_depart");
		return mView;
	}

	// 保存、更新部门
	@RequestMapping(value = "saveDepart")
	private String saveDepart(@ModelAttribute Department department) {
		departmentServiceImpl.saveOrUpdateDepart(department);
		return "redirect:listDepart";
	}

	// 删除单个部门
	@RequestMapping(value = "deleteDepart")
	private String deleteDepart(@RequestParam("id") Long id) {
		departmentServiceImpl.deleteDepart(id);
		return "redirect:removeDepart";
	}


	// 根据所选ids删除部门
	@RequestMapping(value = "deleteDepartByIds")
	private String deleteAllDepartByIds(@RequestParam("depart_ids") String[] ids) {
		if (ids != null) {
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Long.parseLong(ids[i]));
			}
			System.out.println(list);
			departmentServiceImpl.deleteDepartByIds(list);
		}
		System.out.println("执行方法");
		return "redirect:removeDepart";
	}

//	@RequestMapping("listDepartPage")
//	private String getDepartmentListPage(HttpServletRequest request) {
//		Department department = new Department();
//
//		String requestPage = request.getParameter("requestPage");
//
//		int recordCount = departmentServiceImpl.getDepartmentCount(department);
//		pager.init(recordCount, pager.getPageSize(), requestPage);
//
//		List<Department> departmentList = departmentServiceImpl.getDepartmentPaginatedList(department,
//				pager.getFirstRow(), pager.getRowCount());
//
//		request.getServletContext().setAttribute("departmentList", departmentList);
//
//		// request.getServletContext().put("departmentList", departmentList);
//		request.setAttribute("department", department);
//		request.setAttribute("pager", pager);
//
//		return "redirect:listDepart";
//	}
	
	
	@RequestMapping("/pageable")
	  public String pageable(){
	    //Pageable是接口，PageRequest是接口实现
	    //PageRequest的对象构造函数有多个，page是页数，初始值是0，size是查询结果的条数，后两个参数参考Sort对象的构造方法
	    Pageable pageable = new PageRequest(0,10);
	    Page<Department> page = departmentServiceImpl.getPageByFlag(IConstant.PRODUCT_IS_UP,pageable);
	    //查询结果总行数
	    System.out.println(page.getTotalElements());
	    System.out.println("ssdsdsdsdsdsd");
	    //按照当前分页大小，总页数
	    System.out.println(page.getTotalPages());
	    //按照当前页数、分页大小，查出的分页结果集合
	    for (Department department: page.getContent()) {
	      System.out.println(department.toString());
	    }
	    System.out.println("-------------------------------------------");
	    
	    return "redirect:listDepart";
	  }

	@RequestMapping("getall")
	public ModelAndView getAll(HttpServletRequest request,
			@RequestParam(value="number",defaultValue="0")Integer number,
			@RequestParam(value="size",defaultValue="10")Integer size){
		return toAllProduct(number, size);
	}
	
	
	private ModelAndView toAllProduct(Integer number,Integer size){
		ModelAndView mv = new ModelAndView();
		Pageable pageable = new PageRequest(number, size);
		Page<Department> pageList = departmentServiceImpl.getPageByFlag(IConstant.PRODUCT_IS_UP,pageable);
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		//商品分页信息
		mv.addObject("pList", pageList);
		mv.addObject("cList", departmentList);
		mv.setViewName("product/all");
		return mv;
	}
	
	
	
}
