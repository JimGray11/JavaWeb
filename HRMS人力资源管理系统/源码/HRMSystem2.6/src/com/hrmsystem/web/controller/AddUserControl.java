package com.hrmsystem.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.domain.Departments;
import com.hrmsystem.domain.Positions;
import com.hrmsystem.domain.UserInfo;
import com.hrmsystem.domain.UsersLogin;
import com.hrmsystem.service.impl.DepartmentServiceImpl;
import com.hrmsystem.service.impl.PositionServiceImpl;
import com.hrmsystem.service.impl.UserInfoServiceImpl;
import com.hrmsystem.utils.WebUtils;

public class AddUserControl  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  String type=request.getParameter("type");
		  response.setContentType("text/html;charset=utf-8");
		  //获取输出流out对象
		    PrintWriter  out=response.getWriter();
		  
			UserInfoServiceImpl   userInfoService=new UserInfoServiceImpl();
			
		  if(type!=null&& type.equals("createUser")){
			  //调用部门中的函数，在部门选择框中选择所有的部门
			  DepartmentServiceImpl  departmentService=new DepartmentServiceImpl();
			  
			  List<Departments>listDep=departmentService.getAllDepRelation();
			  
			  //调用 岗位管理中函数 ,岗位信息中显示出所有的岗位信息
			  PositionServiceImpl  positionService=new PositionServiceImpl();
			  List<Positions>listPost= positionService.getAllPostions();
			  
		    //获取数据库中的所有用户名名
			 List<UsersLogin> listLoginName= userInfoService.getLoginName();
			  
			  request.setAttribute("listPost",listPost);
			  
			  request.setAttribute("listDep",listDep);
			  
			  request.setAttribute("listLoginName", listLoginName);
			  
			  request.getRequestDispatcher("System_User/saveUI.jsp").forward(request, response);
		  }
		  //调用封装对象 将表单提交的用户信息封装为userInfo Bean 
		  UserInfo  userInfo=WebUtils.requestToBean(request, UserInfo.class);
		 
		 
		  
		  
		  Boolean boolean1=userInfoService.saveUserInfo(userInfo);
		  if(boolean1){
				//提示保存数据成功,跳转到saveUI.jsp 页面
			  out.print("<script type='text/javascript'>alert('新建用户成功');document.location.href='System_User/saveUI.jsp';</script>");
			  //清空out中的缓存并关闭资源
			  out.flush();
			  out.close();
		  }
		  
		  
	}
	

}
