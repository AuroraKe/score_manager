<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级名称</title>
	<script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
	<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script>
	<script type="text/javascript">
		var contextPath = "${contextPath}";
	</script>
</head>
<body>
	<form action="<%=path %>/classes/updateById">
	    	<div class="form-inline">
	    		<input type="hidden" name="class_token" value="${token }">
	    		<input type="hidden" name="class_id" value="${sessionScope.class_id }">
				<input type="text" class="form-control" name="class_name" placeholder="班级名称">
				<button type="submit" class="btn btn-primary">提交</button>
			</div>
	    </form>
</body>
</html>