package com.hrmsystem.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.hrmsystem.domain.DeparmentsShow;
import com.hrmsystem.service.impl.DepartmentServiceImpl;

public class ShowDepartmentControl extends HttpServlet {
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
		
		
		//从数据库中提取所有的部门
       DepartmentServiceImpl departmentService=new DepartmentServiceImpl();
		
	
    //从请求端判断用户请求的操作类型
		String type=request.getParameter("type");
		if(type!=null){
		if(type.equals("del")){
			//获取需要删除记录的部门名称
			String delName=request.getParameter("delName");
			departmentService.deleteDepRecord(delName);
			/*
			if(boolean1){
			  request.setAttribute("list", list);
			  
				//提示保存数据成功,跳转到saveUI.jsp 页面
			  out.print("<script type='text/javascript'>document.location.href='System_Department/list.jsp';</script>");
			  //清空out中的缓存并关闭资源
			  out.flush();
			  out.close();
			 
			}*/
		}
		
     }
		//获取数据库中的所有数据
		List<DeparmentsShow> list=new ArrayList<DeparmentsShow>();
		list=departmentService.getAllDeparmentsShows();
		
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("System_Department/list.jsp").forward(request, response);
  }
}

	

