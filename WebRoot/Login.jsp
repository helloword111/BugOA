<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import='javax.servlet.http.*' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String errInfo =(String)request.getAttribute("err");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
  		<%String account_number="";
  		 Cookie cookies[]=request.getCookies();
  		if(cookies!=null){
  		for(Cookie cookie:cookies){
  			if(cookie.getName().equals("account_number")){
  			 account_number=cookie.getValue();
  			}
  		}
  		}
 %>  		
 	
 	<h1>bug研究所欢迎你</h1>
		<h2>用户登录</h2>
		<form action='/BugOA2/LoginClServlet' method='post'>
		账	号:<input type='text' name='account_number' value='<%= account_number%>' /><br/>
		密	码:<input type='password' name='password'/><br/>
		 <input type='checkbox' value='keep' name='iskeepinfo'/>在此电脑上保存该账号<br/>
		<input type='submit' value='登录'/>
		<input type='submit' value='注册'/><br/>
		</form>
<%
if(errInfo!=null){
 %>
		 <font color='red'><%=errInfo %></font>
<%
}
 %>		 
 
		 <!-- <hr/><img src='img/1.png'/>  -->

		
  </body>
</html>
