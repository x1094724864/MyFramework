<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改部门信息</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.wysiwyg.old-school.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style2.css">
<style type="text/css">
span.item{
font-style: green;
font-size:15px;
font: 楷体;
}
/* tr.hidden{align-content: 
height:0px;
 */

}
.item{
font-weight: bold;
font-size:15px;
align-content: center;
color: red;
position: relative;
left: 30px;
}
</style>
</head>
<body>
	<!--     内容      -->
	<!-- <div id="content" class="white"> -->
	<div id="content" class="white">
		<h1>
			<img src="../../images/posts.png" alt="">员工管理——编辑员工信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">员工列表</div>
			<div class="content">
				<form action="saveEmployee" method="post">
					<table align="center">
						<tr class="hidden" style="height: 0px;">
							<td colspan="2"><input type="hidden" name="id"
								value="${employee.id }" /></td>
						</tr>
						<tr class="hidden">
							<td colspan="2"><input type="hidden" name="department"
								value="${employee.department }" /></td>
						</tr>
<%-- 						<tr>
							<td colspan="2"><input type="hidden" name="employee.department_id"
								value="${employee.department_id }" /></td>
						</tr> --%>

						<tr>
							<td><span class="title" >员工编号</span></td>
							<td><input type="text" name="employee_id"
								value="${employee.employee_id }" tabindex="1" /></td>
						</tr>
						<tr>
							<td ><span class="title">员工姓名</span></td>
							<td><input type="text" name="name"
								value="${employee.name }" tabindex="2" /></td>
						</tr>
						<tr>
							<td><span class="title" >性别</span></td>
							<td><input type="radio" name="gender" value="男" checked="checked" tabindex="3">男
								<input type="radio" name="gender" value="女" tabindex="4">女  </td>
						</tr>
					
						<tr>
							<td ><span class="title" >部门</span></td>
							<td><select name="departmentName" tabindex="5">
							<option selected="selected">-----请选择部门-----</option>
									<c:forEach var="depart" items="${List}"
										varStatus="vs">
										<option>${depart.departmentName}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td ><span span class="title">学历</span></td>
							<td><select name="education" tabindex="6">
									<option selected="selected">-----请选择学历-----</option>
									<option>本科</option>
									<option>大专</option>
									<option>高中</option>
									<option>高中以下</option>
							</select></td>

						</tr>
						<tr>
							<td><span span class="title" >专业</span></td>
							<td><input type="text" name="profession"
								value="${employee.profession}" tabindex="7" /></td>
						</tr>
						<%-- <tr>
							<td ><span class="title">入职时间</span></td>
							<td><input type="text" name="entry_Time"
								value="${employee.entry_Time }" tabindex="8"/></td>
						</tr> --%>
						<tr>
							<td ><span span class="title">地址</span></td>
							<td><input type="text" name="address"
								value="${employee.address }" tabindex="9" /></td>
						</tr>
						<tr>
							<td><span span class="title" >电话号码</span></td>
							<td><input type="text" name="tel_number"
								value="${employee.tel_number }" tabindex="10" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" value="提交" tabindex="11" />&nbsp;<input
								type="reset" value="重置" /></td>
						</tr>

					</table>

				</form>

				<!-- <button>
					<a href="modDepart.action">获取所有</a>
				</button> -->


			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>



	<%-- <div id="content" class="white">
		<form action="saveDepart.action" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="department.id"
						value="${department.id }" /></td>
				</tr>
				<tr>
					<td><input type="text" name="department.id"
						value="${department.id }" /></td>
				</tr>
				<tr>
					<td>部门编号</td>
					<td><input type="text" name="department.department_num"
						value="${department.department_num }" /></td>
				</tr>
				<tr>
					<td>部门名称</td>
					<td><input type="text" name="department.department_name"
						value="${department.department_name }" /></td>
				</tr>
				<tr>
					<td>部门描述</td>
					<td><textarea rows="5" cols="21"
							name="department.department_desc"
							style="margin: 0px; width: 168px; height: 102px;"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交" /><input type="reset"
						value="重置" /></td>
				</tr>
			</table>
		</form>
	</div> --%>
</body>
</html>