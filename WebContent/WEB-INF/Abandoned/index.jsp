<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=GB2312" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生成绩管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<frameset  framespacing="1" rows="69,*" frameborder="no">
		<frame name="top" scrolling="no" noresize="noresize" src="<%=request.getContextPath() %>/user/top">
		<frameset cols="178,*">
			<frame name="menu" target="main" src="<%=request.getContextPath() %>/user/menu" marginwidth="0" marginheight="0" scrolling="no" noresize="noresize">
			<frame src="<%=request.getContextPath() %>/user/firstpage" name="main" scrolling="auto">
		</frameset>
	</frameset>
  </head>
  
  <body>
    	
  </body>
</html>
