package com.hrmsystem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.domain.Positions;
import com.hrmsystem.service.impl.PositionServiceImpl;
import com.hrmsystem.utils.WebUtils;


public class ShowPositionControl extends HttpServlet {
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
		PositionServiceImpl  serviceImpl=new PositionServiceImpl();
		
		String type=request.getParameter("type");
		String postName=request.getParameter("postName");
		
		if(type!=null&&type.equals("createPost")){
			//将表单提交的数据封装为postion 对象
			Positions  position=WebUtils.requestToBean(request, Positions.class);
			//保存岗位信息
			serviceImpl.savePositionInfo(position);
			
		}
		//从数据库中删除数据记录
		if(type!=null&&type.equals("del")){
			Boolean b=serviceImpl.deletePositionInfo(postName);
			System.out.println("删除数据库中的数据成功"+b+type +postName);
		}
		
		
		//调用业务逻辑层中 getAllPosition()方法，获取所有的岗位信息
		
		List<Positions>positionList=serviceImpl.getAllPostions();
		
		//对获取的岗位信息列表集合进行判断
		if(positionList!=null){
			//为什么设置在session中在jsp中读取数据的就会出现错误
			//request.getSession().setAttribute("positionList",positionList);
			request.setAttribute("positionList",positionList);
			request.getRequestDispatcher("System_Role/list.jsp").forward(request,response);
		}
		
		
	}

}
