<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script>
<script type="text/javascript">
	var contextPath = "${contextPath}";
	<%-- $(function() {
		$("#top").load("<%=request.getContextPath() %>/user/top");
		$("#classes").click(function() {
			$("#main").load("<%=path %>/classes/classes_add");
			
		});
	}); --%>
</script>
</head>
<body>
	<div id="top" style="height: 100px;"></div>
	<nav class="navbar navbar-default">
		<div class="navabr-header">
			<a href="#" class="navbar-brand">Brand</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#target">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="target">
			<ul class="nav navbar-nav">
				<li class="drop-down">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">基础数据管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="<%=path %>/classes/classes_add">班级信息管理</a></li>
					  <li><a href="<%=path %>/teacher/teacher_manager">教师信息管理</a></li>
					  <li><a href="App_information/lessionman.jsp" target="main">课程信息管理</a></li>
					  <li><a href="App_student/studentman.jsp" target="main">学生信息管理</a></li>
					</ul>
				</li>
				<li class="drop-down">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">成绩录入<span class="caret"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="#" id="classes" target="main">学生成绩录入</a></li>
					</ul>
				</li>
				<li class="drop-down">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">成绩查询<span class="caret"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="<%=path %>/classes/classes_add" target="main">学生成绩查询</a></li>
					</ul>
				</li>
				<li class="drop-down">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">系统管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="<%=path %>/classes/classes_add" target="#main">自动生成系统用户</a></li>
					  <li><a href="<%=path %>/classes/classes_add" target="main">手工生成系统用户</a></li>
					  <li><a href="<%=path %>/classes/classes_add" target="main">修改当前用户密码</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div id="main"></div>
</body>
</html>