<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import='com.bugoa.pojo.*'%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 	//取出loginusers
		User u= (User) request.getSession().getAttribute("loginusers");
		if(u==null){
			//
			request.setAttribute("err", "请输入用户名和密码登录");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
		
		%>
   这里是主页面。 <br>
  <div> <a href="/BugOA2/UserManagement.jsp">成员信息管理</a></div>
  </body>
</html>
