<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="robots" content="all,follow">
		<!-- Bootstrap CSS-->
		<link rel="stylesheet" href="css/login/bootstrap.min.css">
		<!-- theme stylesheet-->
		<link rel="stylesheet" href="css/login/style.default.css"
			id="theme-stylesheet">
		<!-- Javascript files-->
		<script src="js/nav/jquery.min.js"></script>
		<script src="js/nav/bootstrap.min.js"></script>
	</head>

	<body class="home">
		<!-- navbar-->
		<header class="header" style="background:#333333;">
		<div role="navigation" class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<div class="navbar-buttons">
						<button type="button" data-toggle="collapse"
							data-target=".navbar-collapse" class="navbar-toggle navbar-btn">
							Menu
							<i class="fa fa-align-justify"></i>
						</button>
					</div>
				</div>
				<div id="navigation" class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li class="active">
								<a href="show">Home</a>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">用户管理
								<b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectWithPage?pageNow=1">查询用户</a>
								</li>
								<li>
									<a href="insertUser">添加用户</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">职位管理<b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectJob?pageNow=1">查询职位</a>
								</li>
								<li>
									<a href="insertJob">添加职位</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">部门管理<b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectDept?pageNow=1">部门职位</a>
								</li>
								<li>
									<a href="insertDept">添加部门</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">员工管理
								<b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectEmployee?pageNow=1">查询员工</a>
								</li>
								<li>
									<a href="insertEmployee">添加员工</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">公告管理<b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectNotice?pageNow=1">查询公告</a>
								</li>
								<li>
									<a href="insertNotice">添加公告</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">文件管理<b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectDocument?pageNow=1">查询文件</a>
								</li>
								<li>
									<a href="uploads">上传文件</a>
								</li>
							</ul>
						</li>
						<li>
								<a href="sessionRemove">Quit</a>
						</li>
						</ul>
				</div>
			</div>
		</div>
		</header>

<section class="background-gray-lightest">
		<div class="row">
			<div class="col-lg-8">
				<div class="box-simple">
				</div>
			</div>
		</div>

		<div class="content">
		<form:form action="updateHandleEmployee" commandName="upEmployee" method="post">
			<table  style="margin:0 auto;">
				<tr>
					<td>
						姓名：
					</td>
					<td>
						<form:input path="NAME" />
					</td>
					<td>
						<form:errors path="NAME" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						身份证号码：
					</td>
					<td>
						<form:input path="CARD_ID" />

					</td>
					<td>
						<form:errors path="CARD_ID" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						性别：
					</td>
					<td>
						<select name="SEX" value="${upEmployee.SEX}">
							<option value="">
								--请选择性别--
							</option>
							<option value="1"
								<c:if test="${upEmployee.SEX==1}">selected</c:if>>
								男
							</option>
							<option value="2"
								<c:if test="${upEmployee.SEX==0}">selected</c:if>>
								女
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						职位：
					</td>
					<td>
						<select name="JOB_ID" value="${upEmployee.JOB_ID}">
							<option value="">
								--请选择职位--
							</option>
							<c:forEach items="${jobList}" var="job">
								<option value="${job.ID}"
									<c:if test="${upEmployee.JOB_ID==job.ID}">selected</c:if>>
									${job.NAME}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						学历：
					</td>
					<td>
						<form:input path="EDUCATION" />
					</td>
					<td>
						<form:errors path="EDUCATION" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						邮箱：
					</td>
					<td>
						<form:input path="EMAIL" />
					</td>
					<td>
						<form:errors path="EMAIL" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						手机：
					</td>
					<td>
						<form:input path="PHONE" />
					</td>
					<td>
						<form:errors path="PHONE" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						电话：
					</td>
					<td>
						<form:input path="TEL" />
					</td>
					<td>
						<form:errors path="TEL" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						政治面貌：
					</td>
					<td>
						<form:input path="PARTYl" />
					</td>
					<td>
						<form:errors path="PARTYl" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						QQ号码：
					</td>
					<td>
						<form:input path="QQ_NUM" />
					</td>
					<td>
						<form:errors path="QQ_NUM" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						联系地址：
					</td>
					<td>
						<form:input path="ADDRESS" />
					</td>
					<td>
						<form:errors path="ADDRESS" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						邮政编码：
					</td>
					<td>
						<form:input path="POST_CODE" />
					</td>
					<td>
						<form:errors path="POST_CODE" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						出生日期：
					</td>
					<td>
						<form:input path="BIRTHDAY" />
					</td>
					<td>
						<form:errors path="BIRTHDAY" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						名族：
					</td>
					<td>
						<form:input path="RACE" />
					</td>
					<td>
						<form:errors path="RACE" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						所学专业：
					</td>
					<td>
						<form:input path="SPECIALITY" />
					</td>
					<td>
						<form:errors path="SPECIALITY" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						爱好：
					</td>
					<td>
						<form:input path="HOBBY" />
					</td>
					<td>
						<form:errors path="HOBBY" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						备注：
					</td>
					<td>
						<form:input path="REMARK" />
					</td>
					<td>
						<form:errors path="REMARK" cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td>
						所属部门：
					</td>
					<td>
						<select name="DEPT_ID" value="${upEmployee.DEPT_ID}" />
							<option value="">
								--请选择所属部门--
							</option>
							<c:forEach items="${deptList}" var="dept">
								<option value="${dept.ID}"
									<c:if test="${upEmployee.DEPT_ID==dept.ID}">selected</c:if>>
									${dept.NAME}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="添加">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</section>

		<footer class="footer">
					<div class="footer__copyright">
						<div class="container">
							<div class="row">
								<div class="col-md-6">
									<p>
										Copyright &copy; 2019.Company name All rights reserved.
									</p>
								</div>
								<div class="col-md-6">
									<p class="credit"></p>
								</div>
							</div>
						</div>
					</div>
					</footer>
	</body>
</html>
