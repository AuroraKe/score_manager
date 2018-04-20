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
	<%-- <script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
	<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script> --%>
	<%-- <script type="text/javascript">
		$(function() {
				alert("test");
			$("#logout").click(function() {
				var url = "<%=path%>/user/logout";
				var data = {"time": new Date()};
				$.post(url, data, function() {
					window.location.href="<%=path%>/index.jsp";
				});
			});
		});
	</script> --%>
</head>
<body>
<%-- <form action="<%=path%>/index.jsp"> --%>
	<!-- <div style="margin-top: 10px;z-index: 2;position: absolute;margin-left: 95%;">
		<input id="logout" type="button" class="btn btn-warning btn-sm" value="注销">
	</div> -->
<!-- </form> -->
	<div style="z-index: 1;position: absolute;margin-left: 45%">
		<h1>学生成绩管理系统</h1>
	</div>
	<div>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
    <li class="drop-down">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown">基础数据管理<span class="caret"></span></a>
		<ul class="dropdown-menu nav navbar-nav">
		  <li><a href="#home" data-toggle="tab">班级信息管理</a></li>
		  <li><a href="App_information/teacherman.jsp" target="main">教师信息管理</a></li>
		  <li><a href="App_information/lessionman.jsp" target="main">课程信息管理</a></li>
		  <li><a href="App_student/studentman.jsp" target="main">学生信息管理</a></li>
		</ul>
	</li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">...</div>
    <div role="tabpanel" class="tab-pane" id="profile">...</div>
    <div role="tabpanel" class="tab-pane" id="messages">...</div>
    <div role="tabpanel" class="tab-pane" id="settings">...</div>
  </div>

</div>
</body>
</html>