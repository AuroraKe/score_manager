<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application">
</c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生成绩管理系统</title>
<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css">
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript" src="./js/verify.js"></script>
<script type="text/javascript" src="./js/authentication.js"></script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/user/login" method="post">
	<div style="margin-top: 100px"></div>
	<div style="width: 300px;margin-left: 50%">
		<div class="formgroup">
			<h1>学生成绩管理系统</h1>
		</div>
		<label id="error" style="text-align: center;">&nbsp;</label>
		<div class="form-group">
			<label for="username">用户名</label>
			<input type="text" class="form-control" id="username" name="username" placeholder="用户名">
		</div>
		<div class="form-group">
			<label for="password">密码</label>
			<input type="password" class="form-control" id="password" name="password" placeholder="密码">
		</div>
		<div class="form-group">
			<label for="verifyCode">验证码</label><br>
			<div class="form-inline">
				<input type="text" class="form-control" id="verifyCode" name="verifyCode" placeholder="验证码">
				<img id="img" style="margin-left: 10px" src="<%=request.getContextPath() %>/verification" onclick="changeImg()"/>
			</div>
		</div>
		<select name="select" class="form-control">
			<option value="1" label="系统管理员"/>
			<option value="2" label="信息管理员"/>
			<option value="3" label="教师"/>
			<option value="4" label="学生" />
		</select>
		<button type="submit" class="btn btn-default" style="height: 30px;width: 100%;background-color: #76EE00">登录</button>
	</div>
	</form>
</body>
</html>