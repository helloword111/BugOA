<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import='com.bugoa.pojo.*'%>
<%@ page import='com.bugoa.service.dao.*'%>
<%@ page import='com.bugoa.service.impl.*'%>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
 
<script type="text/javascript" src="pet.js"></script>
  <body class="background">
	<script type='text/javascript' language='javascript'>
			function gotoPageNow(){
				var pageNow=document.getElementById('pageNow');
				window.open('/PetsManager2/ManageUser?pageNow='+pageNow.value,'_self');}
				function confirmOper(){ return window.confirm('真的要删除该用户吗?'); }
		</script>
		<%
		
		
		//定义分页需要的变量
		int pageNow=1;//当前页
		int pageCount = 0;
		
		//接收用户的pageNow
		String sPageNow=request.getParameter("pageNow");
		if(sPageNow!=null){
		    pageNow=Integer.parseInt(sPageNow);
		}
		
		int pageSize=2;//指定每页显示3条记录
			
		//UsersService usersService = new UsersService();
		IOperateDb  iOperate=new OperateDbImple();
	        pageCount= iOperate.getPageCount(pageSize);
	        
			ArrayList<User> al= iOperate.getUsersByPage(pageNow, pageSize);
			
			%>
	
	<div  class="brand">
    </div>
    
    <div class="investiget">
        <div class="meau"><a href="/BugOA2/UserManagement.jsp" class=" a1">用户管理界面</a></div>

    </div>
    
    
    <div id="barM">
   		
        </div>
        
        <div style="float:right; margin-bottom:10px;">
        
        <input placeholder="请输入用户名" name='username'/>
        <input type='submit' value='查找'/>
        </form>
        </div>
        
      
        <div>
          <table>
            <tr style=" border-bottom:50px;">
              <td class=" td_head">用户名</td>
              <td class=" td_head">账号</td>
              <td class=" td_head">性别</td>
              <td class=" td_head">QQ</td>
              <td class=" td_head">删除信息</td>
              <td class=" td_head">修改信息</td>
            </tr>
           </table>
		   
           <table>
           <%for(User u:al){%>
            <tr>
              <td><%=u.getUsername() %></td>
              <td><%=u.getAccount_number()%></td>
              <td><%=u.getSex()%></td>
               <td><%=u.getQQ()%></td>
              <%-- <td><a onClick='return confirmOper();' href='/PetsManager2/UserClServlet?type=del&id=<%=u.getId()%>'>删除该条信息</a></td>
              <td><a href='/PetsManager2/UserClServlet?type=gotoUpView&id=<%=u.getId()%>'>修改该条信息</a></td> --%>
	        <%}%>
            </tr>
          </table>
          </div>
          <button class="add"><a href="/PetsManager2/AddUserView">添加</button>
        
          <div style="color:#000; width:400px; height:20px; margin-left:250px; margin-bottom:0;margin-top:150px; ">
          	<%if(pageNow!=1){%>
            	<a href="/BugOA2/UserManagement.jsp?pageNow=<%=pageNow-1%>" class="a3">上一页</p></a>
            <%}%> 
            <%for(int i=1;i<=pageCount;i++){%>
            	<a href="/BugOA2/UserManagement.jsp?pageNow=<%=i%>" class="a3"><<%=i%>></p></a>
            <%}%>
            <%if(pageNow!=pageCount){%>
            	<a href="/BugOA2/UserManagement.jsp?pageNow=<%=pageNow+1%>" class="a3">下一页</p></a>
            <%}%>
          &nbsp;&nbsp;&nbsp;当前页<%=pageNow%>/总页数<%=pageCount%><br/>
          </div>
	      <br/>跳转到<input type='text' id='pageNow' name='pageNow'/><input type='button' onClick='gotoPageNow()' value='跳'/>
      </div>
	</div> 
	<button style="float:left;"><a href="/BugOA2/MainFrame.jsp" class=" a1">返回</a></button>
</body>
</html>
