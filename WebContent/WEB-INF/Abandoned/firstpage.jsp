<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<%!String days[];%>
<body>
	<%
		days = new String[42];
		for (int i = 0; i < 42; i++) {
			days[i] = "";
		}
	%>     
 <%
      	GregorianCalendar currentDay = new GregorianCalendar();
		
		int minutes=currentDay.get(Calendar.MINUTE);
		int hour=currentDay.get(Calendar.HOUR_OF_DAY);
      	int today = currentDay.get(Calendar.DAY_OF_MONTH);
      	int month = currentDay.get(Calendar.MONTH);
      	int year = currentDay.get(Calendar.YEAR);
      	out.println(year + "年" + (month + 1) + "月" + today + "日"+hour+"时"+minutes+"分");
      	Calendar thisMonth = Calendar.getInstance();
      	thisMonth.set(Calendar.MONTH, month);
      	thisMonth.set(Calendar.YEAR, year);
      	thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
      	thisMonth.set(Calendar.DAY_OF_MONTH, 1);
      	int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
      	int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
      	for (int i = 0; i < maxIndex; i++) {
      		days[firstIndex + i] = String.valueOf(i + 1);
      	}
      %>     
   
 <table border="0" width="300" height="120">     
 <div align=center>     
     <tr>     
         <th width="25" height="16"><font color="red">日</font></th>     
         <th width="25" height="16">一</th>     
         <th width="25" height="16">二</th>     
         <th width="25" height="16">三</th>     
         <th width="25" height="16">四</th>     
         <th width="25" height="16">五</th>     
         <th width="25" height="16"><font color="red">六</font></th>     
     </tr>     
 	<%
      	for (int j = 0; j < 6; j++) {
    %>     
 	<tr>     
    	<%
        	for (int i = j * 7; i < (j + 1) * 7; i++) {
        %>     
           <td width="15%" height="16" valign="middle" align="center">     
        <%
           	if ((i - firstIndex + 1) == today) {
        %>   
   <a href=""><font color="red"><%=days[i]%></font></a>   
   <%} else {%>   
   <%=days[i]%>   
   <%
      	}
      %>   
   </td>     
         <%
              	}
              %>     
     </tr>     
 <%
      	}
      %>     
 </div>     
 </table>
  </body>
</html>
