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
    
    <title>My JSP 'regitser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
html{   
    width: 100%;   
    height: 100%;   
    overflow: hidden;   
    font-style: sans-serif;   
}   
body{   
    width: 100%;   
    height: 100%;   
    font-family: 'Open Sans',sans-serif;   
    margin: 0;    
}   
#login{   
    position: absolute;   
    top: 50%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 200px;   
    background-color:rgba(74,55,74,0.5);  
    border-radius: 15px;  
    
}   
#login h1{   
    color: #000;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: center;   
}   
h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
}   
input{   
    width: 200px;   
    height: 18px;   
    margin-bottom: 10px;   
    outline: none;   
    padding: 10px;   
    font-size: 13px;   
    color: #fff;   
    text-shadow:1px 1px 1px;   
    border-top: 1px solid #312E3D;   
    border-left: 1px solid #312E3D;   
    border-right: 1px solid #312E3D;   
    border-bottom: 1px solid #56536A;   
    border-radius: 4px;   
    background-color: #2D2D3F;     
}   
.but{   
    width: 100px;   
    min-height:30px;   
    display: block;   
    background-color: #4a77d4;   
    border: 1px solid #3762bc;   
    color: #fff;   
    padding: 3px 14px;   
    font-size: 15px;   
    line-height: normal;   
    border-radius: 5px;  
    margin: 0 auto;
    text-align:center;
}  
#tab{
	margin: 0 auto;
}
</style>

<script type="text/javascript" src="js/login/jquery.min.js"></script>
<script type="text/javascript" src="js/login/canvans.js"></script>
</head>

	<body>
	<div id="login">
	<form action="show">
		<font color="red">${msgs}</font>
		<font color="red">${msg}</font>
		  <h1>Login</h1>  
			<table id="tab">
				<tr>
					<td>
						<input name="loginname"  required="required" placeholder="用户名" />
					</td>
				</tr>

				<tr>
					<td>
						<input name="PASSWORD"  required="required" placeholder="密码" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="登录" class="but">
					</td>
				</tr>
			</table>
		</form>
		</div>
	<canvas id="c" width="300" height="150"></canvas>
	</body>
</html>
