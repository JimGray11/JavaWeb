package com.hrmsystem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hrmsystem.domain.Users;
import com.hrmsystem.service.impl.UserServiceImpl;

public class ShowUserInfoControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		}

	@Override
	protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
	       request.setCharacterEncoding("utf-8");
	       String delUserInfo=request.getParameter("type");
	       String delUser=request.getParameter("delUser");
	       //调用userService 函数获取所有的用户记录
	       UserServiceImpl   serviceImpl=new UserServiceImpl();
	       //判断用户选择的操作类型
	       if(delUserInfo!=null&&delUserInfo.equals("delUserInfo")){
	    	   //1.删除数据库中相应的数据
	    	  serviceImpl.deleteUserRecord(delUser);
	    	//设置每个页面显示的用户记录条数为2
	        }
		        int pageSize=2;
		        //数据分页默认在第一页
		        int pageNow=1;
		        int pageCount;
		        //获取总的页数、
		        pageCount=serviceImpl.getPageUserCount();
		       
		      //获取当前页数
		       String page=request.getParameter("pageNow");
		       if(page!=null){
		    	   pageNow=Integer.parseInt(page);
		       }
		      
		       //根据分页和当前页面 显示分也信息
		       List<Users> userList=serviceImpl.showUserByPage(pageSize, pageNow);
		       
		       request.setAttribute("pageNow", pageNow);
		       request.setAttribute("pageCount", pageCount);
		       request.setAttribute("userList", userList);
		    
				request.getRequestDispatcher("System_User/list.jsp").forward(request, response);
			
	}
	
}
