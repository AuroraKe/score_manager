<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息管理</title>
	<script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
	<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path %>/js/teacher_manager.js"></script>
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
					  <li><a href="<%=path %>/classes/classes_add">班级信息管理</a></li>
					  <li><a href="#">教师信息管理</a></li>
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
		<label>您当前所在位置：教师信息管理->教师信息管理</label>
		<div align="center">
			<a href="#" id="teacher_a_select" class="form-control">查询和维护教师信息<span class="badge">42</span></a>
			<!-- 现代的辅助技术能够识别并朗读由 CSS 生成的内容和特定的 Unicode 字符。为了避免 屏幕识读设备抓取非故意的和可能产生混淆的输出内容（尤其是当图标纯粹作为装饰用途时），
			我们为这些图标设置了 aria-hidden="true" 属性。
			如果你使用图标是为了表达某些含义（不仅仅是为了装饰用），请确保你所要表达的意思能够通过被辅助设备识别，例如，包含额外的内容并通过 .sr-only 类让其在视觉上表现出隐藏的效果。
			如果你所创建的组件不包含任何文本内容（例如， <button> 内只包含了一个图标），你应当提供其他的内容来表示这个控件的意图，这样就能让使用辅助设备的用户知道其作用了。
			这种情况下，你可以为控件添加 aria-label 属性。 -->
			<a href="#" id="teacher_a_add" class="form-control" >录入教师信息</a>
			<div style="height: 10px"></div>
			<form action="<%=path%>/teacher/insert" method="post">
				<!-- 隐藏域，用来保存token，验证是否重复提交 -->
				<input type="hidden" name="token" value="${token}">
				<label for="filter_college">所属学院：</label>
				<!-- id属性在teacher_manager.js页面用来绑定下拉框选项 ，name属性值是为了在后台页面使用getParameter-->
				<select id="filter_college" name="filter_college" class="form-control"></select>
				&nbsp;&nbsp;
				<label for="">教师姓名：</label>
				<!-- 一般情况下id都是在js页面使用，name属性在后台使用 -->
				<input type="text" name="teacher_name" id="teacher_name" class="form-control" placeholder="教师姓名">
				<input type="button" id="selectByName" class="btn btn-primary" value="查询">
				<input type="submit" id="teacher_button_add" class="btn btn-success" style="display: none;" value="添加">
			</form>
		</div>
		<div style="height: 20px"></div>
	</div>
	<div style="height: 20px"></div>
	<div class="col-md-4 col-md-offset-4">
		<table class="table table-striped table-hover" id="teacher_list">
			<tr>
				<td>教师ID</td>
				<td>教师姓名</td>
				<td>所属学院</td>
				<!-- 修改功能未实现 -->
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
	<div id="mymodal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="close" data-dismiss="modal">&times;</div>
					<h3>修改教师信息</h3>
				</div>
				<form action="" class="form-group">
				<div class="modal-body">
					<input type="hidden" name="">
					<label for="filter_college">所属学院：</label>
					<select id="filter_college" name="filter_college" class="form-control"></select>
					<label for="">教师姓名：</label>
					<input type="text" name="teacher_name" id="teacher_name" class="form-control" value="" placeholder="教师姓名">
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-primary" value="提交">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="关闭">
				</div>
				</form>
			</div>
			</div>
	</div>
</body>
</html>