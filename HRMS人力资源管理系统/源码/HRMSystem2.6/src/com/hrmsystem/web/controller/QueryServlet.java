package com.hrmsystem.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrmsystem.utils.*;
import com.hrmsystem.dao.impl.*;
import com.hrmsystem.domain.*;



/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("gbk");

		String actionCode = request.getParameter("actionCode");
		
		Connection connection = DbUtils.getConnection();
		
		if(actionCode.equals("category"))
		{
			CategoryImpl categoryimpl = new CategoryImpl();
			
		String sql = "select * from T_category order by id";
		
		List<Category> list = categoryimpl.getListObject(connection, sql);
		
		request.setAttribute("Category", list);
		
		request.getRequestDispatcher("/Edu/categories.jsp").forward(request, response);
		
		} else if(actionCode.equals("record"))
		{
			RecordImpl recordimpl = new RecordImpl();
			
			String sql ="select * from T_Record order by rid";
			
			List<Record> list = recordimpl.getListObject(connection, sql);
			
			request.setAttribute("Record", list);
			
			request.getRequestDispatcher("Edu/record.jsp").forward(request, response);
			
		}else if(actionCode.equals("score"))
		{
			ScoreImpl scoreimpl = new ScoreImpl();
			
			String sql1 = "select * from t_score order by sid";
			
			List<Score> list = scoreimpl.getListObject(connection, sql1);
			
			request.setAttribute("Score", list);
			
			request.getRequestDispatcher("/Edu/score.jsp").forward(request, response);
			
		}
		
		DbUtils.closeConnection(connection);
		
	}

}
