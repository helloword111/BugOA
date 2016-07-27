package com.bugoa.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bugoa.pojo.User;
import com.bugoa.service.dao.IUserLogin;
import com.bugoa.service.impl.UserLoginImple;



public class LoginClServlet extends HttpServlet {
	private IUserLogin iUser =new UserLoginImple();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取用户提交的账号和密码
		String account_number=request.getParameter("account_number");
		String password=request.getParameter("password");
		//System.out.println(account_number);
		//创建UserLoginImple对象，完成到数据库的验证
		
		User user = new User();
		user.setAccount_number(account_number);
		user.setPassword(password);
		
		//5.根据结果做处理
	    if(iUser.checkUser(user)){
	        	
	    	//把user对象保存到session
	        HttpSession session=request.getSession();
	       	session.setAttribute("loginusers",user);
	       	session.setAttribute("username", user.getUsername());
	        		
	        //说明该用户合法
	        request.getRequestDispatcher("/MainFrame.jsp").forward(request, response);
	    }else{
	        request.setAttribute("err","用户账号或者密码有误！！");
	        request.getRequestDispatcher("/Login.jsp").forward(request,response);
	    }
	}
	
	 
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
