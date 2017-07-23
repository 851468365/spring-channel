<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
  	<h1>测试实体类：student</h1><br/>
  	<a href="student/getStudentsByPage.action?id=003&pageNum=1&pageSize=2">getStudentsByPage</a><br/><br/>
  	<a href="student/getStudentById.action?id=003">getStudentById</a><br/><br/>
	<a href="student/getStudentListMap.action?id=003">getStudentListMap</a><br/><br/>
  	
  	<h1>测试实体类：teacher</h1><br/>
  	<a href="teacher/getTeachersByPage.action?id=003&pageNum=1&pageSize=3">getTeachersByPage</a><br/><br/>
  	<a href="teacher/getTeacherById.action?id=003">getTeacherById</a><br/><br/>
  	
  	
  	
  </body>
</html>
