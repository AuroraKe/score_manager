<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page contentType="text/html; charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>

<title>My JSP 'menu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script>
<link rel="stylesheet" href="<%=path %>/css/href.css">
</head>

<body class="container" style="background-color: #fff;">
	<ul class="list-inline">
	  <li>欢迎您：<%=session.getAttribute("username") %></li>
	</ul>
	  <%int role_id = (int)session.getAttribute("role_id"); %>
	<ul class="list-inline">
	  <li>
		<c:choose>
			<c:when test="${role_id==1 }">您的角色：系统管理员</c:when>
			<c:when test="${role_id==2 }">您的角色：数据管理员</c:when>
			<c:when test="${role_id==3 }">您的角色：教师</c:when>
			<c:when test="${role_id==4 }">您的角色：学生</c:when>
		</c:choose>
	</li>
	</ul>
	<dl>
		<dt>基础数据管理</dt>
		<dd><a href="<%=path %>/classes/classes_add" target="main">班级信息管理</a></dd>
		<dd><a href="App_information/teacherman.jsp" target="main">教师信息管理</a></dd>
		<dd><a href="App_information/lessionman.jsp" target="main">课程信息管理</a></dd>
		<dd><a href="App_student/studentman.jsp" target="main">学生信息管理</a></dd>
	</dl>
	<dl>
		<dt>成绩录入</dt>
		<dd><a href="App_information/score_add.jsp" target="main">学生成绩录入</a></dd>
	</dl>
	<dl>
		<dt>成绩查询</dt>
		<dd><a href="App_information/score_add.jsp" target="main">学生成绩查询</a></dd>
	</dl>
	<dl>
		<dt>系统管理</dt>
		<dd><a href="App_information/score_add.jsp" target="main">自动生成系统用户</a></dd>
		<dd><a href="App_information/score_add.jsp" target="main">手工生成系统用户</a></dd>
		<dd><a href="App_information/modi_pwd.jsp?userid=" target="main">修改当前用户密码</a></dd>
	</dl>
</body>
</html>
