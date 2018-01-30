package com.lx.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lx.entity.Department;
import com.lx.entity.Employee;
import com.lx.service.impl.DepartmentServiceImpl;
import com.lx.service.impl.EmployeeServiceImpl;
import com.lx.utils.Pager;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	Pager pager = new Pager();

	private ModelAndView mView = new ModelAndView();

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	// 获取部门列表
	// 不用JPA实现的 自己写的分页方法
	private List<Employee> getEmpWithPage(String requestPage) {
		int recordCount = employeeServiceImpl.getRecordCount();
		pager.init(recordCount, pager.getPageSize(), requestPage);
		int firstRow = pager.getFirstRow();
		int rowCount = pager.getRowCount();
		List<Employee> employeePageList = employeeServiceImpl.getEmpByPage(firstRow, rowCount);
		return employeePageList;
	}

	// 获取员工列表
	// 分页
	@RequestMapping("listEmp")
	private ModelAndView listEmp(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		List<Employee> employeeList = getEmpWithPage(requestPage);
		session.setAttribute("employeeList", employeeList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("employee/emp_list");
		return mView;
	}

	// 根据部门查找员工
	@RequestMapping("listEmpByDepart")
	private ModelAndView listEmpByDepart(HttpSession session, Long id,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		// List<Employee> employeeList = getEmpWithPage(requestPage);
		int recordCount = employeeServiceImpl.getRecordCountByDepartment(id);
		pager.init(recordCount, pager.getPageSize(), requestPage);
		int firstRow = pager.getFirstRow();
		int rowCount = pager.getRowCount();
		List<Employee> employeeList = employeeServiceImpl.getEmpByDepart(id, firstRow, rowCount);
		session.setAttribute("employeeList", employeeList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("employee/emp_list");
		return mView;
	}

	// 进入员工详细信息页面
	@RequestMapping("detailsEmp")
	private ModelAndView detailsEmp(HttpSession session, Employee employee) {
		Long id = employee.getId();

		Employee emp = employeeServiceImpl.getEmpById(id);
		mView.addObject("emp", emp);
		mView.setViewName("employee/emp_details");
		return mView;
	}

	// 进入员工编辑页面
	@RequestMapping("editEmp")
	private ModelAndView editEmp(HttpSession session, HttpServletRequest request, Employee employee) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		Long id = employee.getId();
		if (id != null) {
			Employee emp = employeeServiceImpl.getEmpById(id);
			employee.setName(emp.getName());
			employee.setGender(emp.getGender());
			employee.setDepartmentName(emp.getDepartmentName());
			employee.setDepartment(emp.getDepartment());
			employee.setAddress(emp.getAddress());
			employee.setEducation(emp.getEducation());
			employee.setEmployee_id(emp.getEmployee_id());
			employee.setProfession(emp.getProfession());
			employee.setTel_number(emp.getTel_number());
		}
		request.setAttribute("List", departmentList);
		mView.setViewName("employee/edit_emp");
		return mView;
	}
	
	// 进入员工修改页面
	@RequestMapping("mod_editEmp")
	private ModelAndView mod_editEmp(HttpSession session, HttpServletRequest request, Employee employee) {
		List<Department> departmentList = departmentServiceImpl.getAllDepart();
		Long id = employee.getId();
		if (id != null) {
			Employee emp = employeeServiceImpl.getEmpById(id);
			employee.setName(emp.getName());
			employee.setGender(emp.getGender());
			employee.setDepartmentName(emp.getDepartmentName());
			employee.setDepartment(emp.getDepartment());
			employee.setAddress(emp.getAddress());
			employee.setEducation(emp.getEducation());
			employee.setEmployee_id(emp.getEmployee_id());
			employee.setProfession(emp.getProfession());
			employee.setTel_number(emp.getTel_number());
			employee.setMail(emp.getMail());
			employee.setEntry_Time(emp.getEntry_Time());
			employee.setPhotoName(emp.getPhotoName());
		}
		request.setAttribute("List", departmentList);
		mView.setViewName("employee/mod_edit_emp");
		return mView;
	}

	// 部门名验证部门是否存在
	@RequestMapping("empIsExistByEmpId")
	@ResponseBody
	public boolean empIsExistByEmpId(HttpServletRequest request, @RequestParam("employee_id") Long employee_id) {
		List<Employee> list = employeeServiceImpl.getByEmployee_id(employee_id);
		if (list.size() > 0) {
			return true; // 表示存在
		}
		return false; // 表示不存在
	}

	// 进入员工修改页面
	@RequestMapping("modEmp")
	private ModelAndView modEmp(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		List<Employee> employeeList = getEmpWithPage(requestPage);
		session.setAttribute("employeeList", employeeList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("employee/mod_emp");
		return mView;
	}

	// 进入员工删除页面
	@RequestMapping("removeEmp")
	private ModelAndView removeEmp(HttpSession session,
			@RequestParam(value = "requestPage", defaultValue = "0") String requestPage) {
		List<Employee> employeeList = getEmpWithPage(requestPage);
		session.setAttribute("employeeList", employeeList);
		session.getServletContext().setAttribute("pager", pager);
		mView.setViewName("employee/remove_emp");
		return mView;
	}

	// 保存、更新员工
	@RequestMapping("saveEmp")
	private String saveEmp(HttpSession session, HttpServletRequest request, Employee employee) throws Exception {
		// ,@RequestParam(value = "photo", required = false) MultipartFile filedata)
		// throws Exception {

		// Employee employee = new Employee();
		String photoName = pushPhoto(session, request, employee);
		employee.setPhotoName(photoName);

		String departmentName = employee.getDepartmentName();
		employee.setDepartment(departmentServiceImpl.getDepartByDepartmentName(departmentName));
		employee.setPhotoName(photoName);
		employeeServiceImpl.saveOrUpdateEmp(employee);
		return "redirect:listEmp";
	}

	// 删除单个员工
	@RequestMapping(value = "deleteEmpById")
	private String deleteEmpById(@RequestParam("id") Long id) {
		employeeServiceImpl.deleteEmpById(id);
		return "redirect:removeEmp";
	}

	// 根据所选ids删除员工
	@RequestMapping(value = "deleteEmpByIds")
	private String deleteAllEmpByIds(@RequestParam("emp_ids") String[] ids) {
		if (ids != null) {
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Long.parseLong(ids[i]));
			}
			System.out.println(list);
			employeeServiceImpl.deleteEmpByIds(list);
		}
		System.out.println("执行方法");
		return "redirect:removeEmp";
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmpList() {
		Pageable pageable = new PageRequest(0, 8);
		List<Employee> empList = (List<Employee>) employeeServiceImpl.getEmpPage(pageable);
		return empList;
	}

	// 上传头像
	public String pushPhoto(HttpSession session, HttpServletRequest request, Employee employee) throws Exception {
		// 上传的是文件路径
		/*
		 * MultipartFile photo = employee.getPhoto(); String path =
		 * session.getServletContext().getRealPath("/media/temporaryupload"); String
		 * fileName = photo.getOriginalFilename(); // 获取图片的扩展名 String extensionName =
		 * fileName .substring(fileName.lastIndexOf(".") + 1); // 新的图片文件名 =
		 * 获取时间戳+"."图片扩展名 String newFileName =
		 * String.valueOf(System.currentTimeMillis()) + "." + extensionName; File
		 * targetFile = new File(path, newFileName);
		 * 
		 * if (!targetFile.exists()) { targetFile.mkdirs(); }
		 *//**
			 * MultipartFile接口中定义了如下很多有用的方法。 使用getSize()方法获得文件长度，以此决定允许上传的文件大小。
			 * 使用isEmpty()方法判断上传文件是否为空文件，以此决定是否拒绝空文件。
			 * 使用getInputStream()方法将文件读取为java.io.InputStream流对象。
			 * 使用getContentType()方法获得文件类型，以此决定允许上传的文件类型。
			 * 使用transferTo（dest）方法将上传文件写到服务器上指定的文件
			 *//*
				 * photo.transferTo(targetFile); String fileUrl = request.getContextPath() +
				 * "/media/temporaryupload/" + newFileName; return fileUrl;
				 */

		// 保存的是图片名称
		String photoName = employee.getPhotoName();
		MultipartFile photo = employee.getPhoto();
		String photoFileName = photo.getOriginalFilename();
		// 获取图片的扩展名
		String extensionName = photoFileName.substring(photoFileName.lastIndexOf(".") + 1);
		// 新的图片文件名 = 获取时间戳+"."图片扩展名
		String newphotoFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
		if (!photo.isEmpty()) {
			// 尺寸大于2m
			// long photoSize = photo.getSize();
			if (photo.getSize() <= 2097152) {
				// if (!photo.equals(null)) {
				// String savePath = request.getContextPath() + "/photo_picture";
				// String savePath = "/ISiteForSSJ/src/main/webapp/picture";
				String savePath = request.getServletContext().getRealPath("/WEB-INF/employee_photo_picture/");
				File targetFile = new File(savePath, photoFileName);
				if (!targetFile.getParentFile().exists()) { // 判断路径是否存在
					targetFile.getParentFile().mkdirs(); // 不存在则创建
				}
				File saveFilePath = new File(savePath + File.separator + newphotoFileName);
				photo.transferTo(saveFilePath);
				photoName = newphotoFileName;
				return photoName;
			}
			return photoName="头像尺寸超出2M";
		}
		return photoName="未选择头像";
	}
}
