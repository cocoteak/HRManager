<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
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
		<header class="header">
		<div role="navigation" class="navbar navbar-default">
			<div class="container">
				<div id="navigation" class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="show">Home</a>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">用户管理
								<b class="caret"></b>
							</a>
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
								class="caret"></b>
							</a>
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
								class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="selectDept?pageNow=1">查询部门</a>
								</li>
								<li>
									<a href="insertDept">添加部门</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" data-toggle="dropdown" class="dropdown-toggle">员工管理
								<b class="caret"></b>
							</a>
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
								class="caret"></b>
							</a>
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
								class="caret"></b>
							</a>
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

		<div id="carousel-home" data-ride="carousel"
			class="carousel slide carousel-fullscreen carousel-fade">
			<!-- Indicators-->
			<ol class="carousel-indicators">
				<li data-target="#carousel-home" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-home" data-slide-to="1"></li>
				<li data-target="#carousel-home" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides-->
			<div role="listbox" class="carousel-inner">
				<div style="background-image: url('images/login/1.jpg');"
					class="item active">
					<div class="overlay"></div>
					<div class="carousel-caption">
						<h1 class="super-heading">
							人事
						</h1>
						<p class="super-paragraph">
							更便捷
						</p>
					</div>
				</div>
				<div style="background-image: url('images/login/2.jpg');"
					class="item">
					<div class="overlay"></div>
					<div class="carousel-caption">
						<h1 class="super-heading">
							管理
						</h1>
						<p class="super-paragraph">
							易操作
						</p>
					</div>
				</div>
				<div style="background-image: url('images/login/3.jpg');"
					class="item">
					<div class="overlay"></div>
					<div class="carousel-caption">
						<h1 class="super-heading">
							系统
						</h1>
						<p class="super-paragraph">
							更易懂
						</p>
					</div>
				</div>
			</div>
		</div>

		<section class="background-gray-lightest negative-margin">
		<div class="container">
			<h1>
				人事管理系统欢迎您
			</h1>
			<p class="lead">
				    &nbsp &nbsp &nbsp &nbsp在民政部门的大力支持下，宏达软件结合人事办公管理的实际情况和实践操作研发的新一代人事管理系统，使一直沿袭传统办公模式而产生的管理效率较低，经营管理水平相对滞后等现象得以改善；而这种新型的办公业务流程自动化、智能分析、科学宏观的管理模式已经成为各个单位的必然需求。
			</p>
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
