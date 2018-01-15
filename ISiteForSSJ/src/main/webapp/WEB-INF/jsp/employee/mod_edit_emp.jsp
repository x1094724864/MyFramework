<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery.wysiwyg.old-school.css">


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/my_style.css">



<!-- jQuery AND jQueryUI -->

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/mod_employee.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/previewImage.js"></script>


<script type="text/javascript">
	$(function() {
		$('#uniform-photo .filename').html("未选择照片");
		$('#uniform-photo .action').html("选择头像");
	})
</script>

<!-- 以下 是自己添加的页面样式 -->
<style type="text/css">
</style>
</head>
<body>
	<!--     内容      -->
	<!-- <div id="content" class="white"> -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">员工管理——编辑员工信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">员工信息</div>
			<div class="content">
				<form action="saveEmp" name="saveEmpForm" method="post"
					enctype="multipart/form-data" onSubmit="return false;">
					<!-- <form action="saveEmp" method="post" > -->
					<table align="center">
						<thead>
							<tr class="hidden" style="height: 0px;">
								<td colspan="3"><input type="hidden" name="id"
									value="${employee.id }" /></td>
							</tr>
						</thead>
						<%-- <tr class="hidden">
							<td colspan="2"><input type="hidden" name="department"
								value="${employee.department }" /></td>
						</tr> --%>

						<tr>
							<td><span class="item">员工编号</span></td>
							<td><div class="input">
									<input type="text" name="employee_id" id="employee_id"
										onchange="checkEmployee_id()" value="${employee.employee_id }"
										tabindex="1" />
								</div></td>
							<td><span id="employee_id_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">员工姓名</span></td>
							<td><div class="input">
									<input type="text" name="name" id="name"
										value="${employee.name }" tabindex="2" />
								</div></td>
							<td><span id="employee_name_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">性别</span></td>
							<td><input type="radio" name="gender" value="男" id="male"
								checked="checked" tabindex="3">男 <input type="radio"
								name="gender" id="female" value="女" tabindex="4">女</td>
							<td><span id="employee_gender_span"></span></td>
						</tr>
						<!-- <tr>
							<td><span class="item">出生日期</span></td>
							<td><input type="date" name="birthDate"></td>
						</tr> -->

						<tr>
							<td><span class="item">部门</span></td>
							<td><div class="select">
									<select name="departmentName" tabindex="5"
										id="empDepartmentName" onchange="checkEmpDepartName()">
										<option selected="selected" value="未选择">-----请选择部门-----</option>
										<c:forEach var="depart" items="${List}" varStatus="vs">
											<option>${depart.departmentName}</option>
										</c:forEach>
									</select>
								</div></td>
							<td><span id="employee_depart_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">入职时间</span></td>
							<td><div class="input">
									<input type="text" name="entry_Time" id="entry_Time"
										 onchange="checkTimeQualified()"
										class="datepicker" value="${employee.entry_Time }"
										tabindex="6" />
								</div></td>
							<td><span id="employee_entry_time_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">学历</span></td>
							<td><div class="select">
									<select name="education" id="education" tabindex="7"
										onchange="checkEducation()">
										<option selected="selected" value="未选择">-----请选择学历-----</option>
										<option>硕士及以上</option>
										<option>本科</option>
										<option>大专</option>
										<option>高中</option>
										<option>其他</option>
									</select>
								</div></td>
							<td><span id="employee_education_span"></span></td>

						</tr>
						<tr>
							<td><span class="item">专业</span></td>
							<td><div class="input">
									<input type="text" name="profession" id="profession"
										onchange="checkProfession()" value="${employee.profession}"
										tabindex="8" />
								</div></td>
							<td><span id="employee_profession_span"></span></td>
						</tr>

						<tr>
							<td><span class="item">地址</span></td>
							<td><div class="input">
									<input type="text" name="address" id="address"
										onchange="checkAddress()" value="${employee.address }"
										tabindex="9" />
								</div></td>
							<td><span id="employee_address_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">电话号码</span></td>
							<td><div class="input">
									<input type="text" name="tel_number" id="tel_number"
										onchange="checkTell()" value="${employee.tel_number }"
										tabindex="10" />
								</div></td>
							<td><span id="employee_tel_span"></span></td>
						</tr>
						<tr>
							<td><span class="item">邮箱</span></td>
							<td><div class="input">
									<input type="text" name="mail" id="mail"
										value="${employee.mail }" onchange="checkMail()" tabindex="11" />
								</div></td>
							<td><span id="employee_mail_span"></span></td>
						</tr>
						<!-- <tr>
							<td><div id="preview" class="controls">
									头像预览 <img id="imghead" border="0"
										onclick="$('#previewImg').click();">
								</div></td>
							<td><div class="col-md-6">
									<input id="previewImg" type="file"
										onchange="previewImage(this)" name="previewImg"
										data-show-upload="false">
								</div></td>
						</tr> -->
						<tr>
							<td><span class="item">头像</span></td>
							<td><div class="input">
									<input type="file" accept="image/*" name="photo" id="photo"
										value="" tabindex="12" />
								</div></td>
							<td><span id="employee_photo_span"></span></td>
						</tr>

						<tr>
							<td></td>
							<td><br>
								<div class="submit">
									<input type="button" value="提交" tabindex="13"
										onclick="saveEmployee()" /><input
										style="position: relative; left: 50px;" type="reset"
										value="重置" tabindex="14" onclick="resetValue()"/>
								</div></td>
							<td><span></span></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>