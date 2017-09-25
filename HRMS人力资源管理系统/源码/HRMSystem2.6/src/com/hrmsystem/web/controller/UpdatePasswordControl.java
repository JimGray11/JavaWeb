package com.hrmsystem.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.service.impl.UserServiceImpl;
import com.hrmsystem.utils.MD5Utils;

public class UpdatePasswordControl extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter  out=response.getWriter();
		//取出当前登录的用户名
		String loginName=request.getSession().getAttribute("loginName").toString();
		String newPassword=request.getParameter("password");
		// 调用UserServiceImpl中的更新函数，对用户密码进行更新
		UserServiceImpl  serviceImpl=new UserServiceImpl();
		
		//使用Md5加密算法对用户密码进行加密,并将密码存放进入数据库
		Boolean  boolean1=serviceImpl.updateUserPassword(loginName, MD5Utils.MD5Encode(newPassword));
		//如果用户密码修改成功,返回到密码更改界面
		if(boolean1){
			out.print("<script type='text/javascript'>alert('密码更改成功');document.location.href='Person_Config/editPasswordUI.jsp';</script>");
		}
	
	}

	

}
