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
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String actionCode = request.getParameter("actionCode");
		
		String[] id = request.getParameterValues("ch");
		
		Connection connection = DbUtils.getConnection();
		
		if(actionCode.equals("categoryDelete"))
		{
			CategoryImpl categoryimpl  = new  CategoryImpl();
			
			for(int i = 0;i < id.length;i++)
			{
				
				String ids = id[i]; 
				
				String sql1="delete from t_category where id=?";
				
				categoryimpl.updateDataRecord(connection, sql1, ids);
			}
			
			String sql2="select * from t_category order by id";
			 
			List<Category> list  = categoryimpl.getListObject(connection, sql2);
			
			request.setAttribute("Category", list);
			
			request.getRequestDispatcher("/Edu/categories.jsp").forward(request, response);
			
		}else if(actionCode.equals("recordDelete"))
		{
			RecordImpl recordimpl = new RecordImpl();
			
			for(int i = 0 ;i < id.length;i++)
			{
				String ids = id[i];
				
				String sql1 = "delete from t_record where rid=?";
				
				recordimpl.updateDataRecord(connection, sql1, ids);
			}
			
			String sql2 ="select * from T_Record order by rid";
			
			List<Record> list = recordimpl.getListObject(connection, sql2);
			
			request.setAttribute("Record", list);
			
			request.getRequestDispatcher("/Edu/record.jsp").forward(request, response);
			
		}else if(actionCode.equals("scoreDelete"))
		{
			ScoreImpl scoreimpl = new ScoreImpl();
			
			for(int i = 0; i< id.length; i++)
			{
				String ids =id[i];
				
				String sql1 = "delete from t_score where sid=?";
				
				scoreimpl.updateDataRecord(connection, sql1,ids);
			}
			
			String sql2 = "select * from t_score order by sid";
			
			List<Score> list = scoreimpl.getListObject(connection, sql2);
			
			request.setAttribute("Score", list);
			
			request.getRequestDispatcher("/Edu/score.jsp").forward(request, response);	
		}
		
	}

}
