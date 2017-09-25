package com.hrmsystem.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.domain.Departments;
import com.hrmsystem.service.impl.DepartmentServiceImpl;
import com.hrmsystem.utils.WebUtils;

public class AddDepartmentControl extends HttpServlet {

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
	    String type=request.getParameter("type");
	     //获取输出流out对象
	    PrintWriter  out=response.getWriter();

		DepartmentServiceImpl  departmentService=new DepartmentServiceImpl();
		
		if(type!=null&&type.equals("createDep")){
			//调用部门列表显示函数，显示所有的部门
			List<Departments> depList=departmentService.getAllDepRelation();
			
			request.setAttribute("depList", depList);
			request.getRequestDispatcher("System_Department/saveUI.jsp").forward(request, response);  
		}
		
		//从request中获取department 对象 
		Departments  department=WebUtils.requestToBean(request, Departments.class);
		
	   // 对departments 对象进行判断
		if(department!=null){
		   //调用departmentService 将数据存入数据库
			Boolean b=departmentService.saveDepartmentInfo(department);
			
			
			if(b){
		
				//提示保存数据成功,跳转到saveUI.jsp 页面
			  out.print("<script type='text/javascript'>alert('新建部门成功');document.location.href='System_Department/saveUI.jsp';</script>");
			  //清空out中的缓存并关闭资源
			  out.flush();
			  out.close();
			}
			
		}
		
		
	
		
		
	}

	
	
}
