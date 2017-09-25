package com.hrmsystem.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.domain.Users;
import com.hrmsystem.service.impl.UserServiceImpl;

public class UserInfoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	       this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取当前登录的用户名
		String loginName=request.getSession().getAttribute("loginName").toString();
		//创建userServiceImpl对象 ,根据用户名获取用户信息
		
		UserServiceImpl  userServiceImpl=new UserServiceImpl();
		
		Users user=userServiceImpl.getUserByLoginName(loginName);
		//将对象加载到session中
		if(user!=null){  //为了防止查询数据库时出现异常
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("Person_Config/editUserInfoUI.jsp").forward(request, response);
		}
		
		
		
		
	}
	
	

}
