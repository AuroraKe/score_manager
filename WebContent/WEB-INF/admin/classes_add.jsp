<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript" src="<%=path %>/js/classes_list.js"></script>
	<script type="text/javascript">
		var contextPath = "${contextPath}";
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
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">基础数据管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
					  <li><a href="#">班级信息管理</a></li>
					  <li><a href="<%=path %>/teacher/teacher_manager" >教师信息管理</a></li>
					  <li><a>课程信息管理</a></li>
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
	<div class="form-inline col-md-4 col-md-offset-4">
		<label>您当前所在位置：班级信息管理->班级信息管理</label>
	</div>
	<form action="<%=path %>/classes/insert">
		<div class="form-inline col-md-4 col-md-offset-4">
			<!-- 隐藏域，用来保存token，验证是否重复提交 -->
			<input type="hidden" name="token" value="${token}">
			<label for="className">录入班级信息：</label>
			<input type="text" class="form-control" name="className">
			<button type="submit" class="btn btn-success">添加</button>
		</div>
	</form>
	<div class="col-md-4 col-md-offset-4">
		<table class="table table-striped table-hover" id="classes_add">
			<tr>
				<td>班级ID</td>
				<td>班级名称</td>
				<td>修改</td>	
				<td>删除</td>
			</tr>
		</table>
		<div class="pager">
		    <input type="button" class="btn btn-default" id="firstPage" value="&laquo;&laquo;">
		    <input type="button" class="btn btn-default" id="prevPage" value="&laquo;" title="上一页">
			  <label id="currPage" style="margin: 5px">&nbsp;</label>
		    <input type="button" class="btn btn-default" id="nextPage" value="&raquo;" title="下一页">
		    <input type="button" class="btn btn-default" id="lastPage" value="&raquo;&raquo;">
		    <label id="total_page" style="margin: 5px">&nbsp;</label>
		</div>
	</div>
</body>
</html>