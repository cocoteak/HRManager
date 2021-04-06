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
		<script src="js/select/selectEmployee.js" charset="gb2312"></script>
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
			<form action="selectEmployee" method="post" id="form1">
				<input type="hidden" id="pageNow" name="pageNow" value="1" />
				<input type="hidden" id="totalPage" value="${totalPage}" />
				<span style="padding: 20%"> 
					姓名： <input name="NAME" value="${paramEmployee.NAME}" /> 
					身份证号码： <input name="CARD_ID" value="${paramEmployee.CARD_ID}" /> 
					手机： <input name="PHONE" value="${paramEmployee.PHONE}" />
					</span>
				<br />
				<span style="padding: 20%"> 所属部门： <select name="DEPT_ID"
						value="${paramEmployee.DEPT_ID}" />
						<option value="">
							--请选择所属部门--
						</option>
						<c:forEach items="${deptList}" var="dept">
							<option value="${dept.ID}"
								<c:if test="${paramEmployee.DEPT_ID==dept.ID}">selected</c:if>>
								${dept.NAME}
							</option>
						</c:forEach>
					</select>
					职位：<select name="JOB_ID" value="${paramEmployee.JOB_ID}">
							<option value="">
								--请选择职位--
							</option>
							<c:forEach items="${jobList}" var="job">
								<option value="${job.ID}"
									<c:if test="${paramEmployee.JOB_ID==job.ID}">selected</c:if>>
									${job.NAME}
								</option>
							</c:forEach>
						</select> 
					 性别： <select name="SEX" value="${paramEmployee.SEX}">
						<option value="">
							--请选择性别--
						</option>
						<option value="1"
							<c:if test="${paramEmployee.SEX==1}">selected</c:if>>
							男
						</option>
						<option value="2"
							<c:if test="${paramEmployee.SEX==2}">selected</c:if>>
							女
						</option>
					</select>
					 <input type="submit" value="查询">
					</span>
			</form>
			<table border="1" style="margin: 0 auto;" width="1200">
				<tr>
					<th>
						<input type="checkbox" id="cks" onClick="myClick()"/>
						<input type="button" value="删除" onClick="deleteItem()"/>
					</th>
					<th>
						ID
					</th>
					<th>
						姓名
					</th>
					<th>
						性别
					</th>
					<th>
						手机号码
					</th>
					<th>
						邮箱
					</th>
					<th>
						职位
					</th>
					<th>
						学历
					</th>
					<th>
						身份证号码
					</th>
					<th>
						部门
					</th>
					<th>
						联系地址
					</th>
					<th>
						建档日期
					</th>
					<th>
						操作
					</th>
				</tr>
				<c:forEach items="${listEmployee}" var="employees">
					<tr>
						<th>
							<input type="checkbox" name="del" value="${employees.ID}" />
						</th>
						<th>
							${employees.ID}
						</th>
						<th>
							${employees.NAME}
						</th>
						<th>
							<c:choose>
								<c:when test="${employees.SEX==1}">男</c:when>
								<c:otherwise>女</c:otherwise>
							</c:choose>
						</th>
						<th>
							${employees.PHONE}
						</th>
						<th>
							${employees.EMAIL}
						</th>
						<th>
							${employees.job.NAME}
						</th>
						<th>
							${employees.EDUCATION}
						</th>
						<th>
							${employees.CARD_ID}
						</th>
						<th>
							${employees.dept.NAME}
						</th>
						<th>
							${employees.ADDRESS}
						</th>
						<th>
							<fmt:formatDate value="${employees.CREATE_DATE}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</th>
						<th>
							<a href="updateEmployee?ID=${employees.ID}">修改</a>
						</th>
					</tr>
				</c:forEach>
			</table>
			<table style="margin: 0 auto;">
				<tr>
					<c:if test="${isHasFirst}">
						<td>
							<a href="javascript:change(1)">首页</a>
						</td>
					</c:if>

					<c:if test="${isHasPre}">
						<td>
							<a href="javascript:change(${pageNow-1})">上一页</a>
						</td>
					</c:if>

					<c:if test="${isHasNext}">
						<td>
							<a href="javascript:change(${pageNow+1})">下一页</a>
						</td>
					</c:if>

					<c:if test="${isHasLast}">
						<td>
							<a href="javascript:change(${totalPage})">末页</a>
						</td>
					</c:if>
				</tr>

				<tr>
					<td colspan="5">
						<c:forEach begin="1" end="${totalPage}" var="i">
							<a href="javascript:change(${i})">${i} </a>
						</c:forEach>
						<input type="text" id="page" />
						<input type="button" value="跳转" onClick="javascript:change2()" />
					</td>
				</tr>
			</table>
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
</html>
