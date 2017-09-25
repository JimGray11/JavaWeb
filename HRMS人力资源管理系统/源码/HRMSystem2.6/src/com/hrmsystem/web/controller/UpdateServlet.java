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
 * Servlet implementation class updateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		String para = request.getParameter("actionCode");
		
		String id =  request.getParameter("id");
		
		Connection connection = DbUtils.getConnection();
		
		if(para.equals("categoryEdit"))
		{
			CategoryImpl categoryimpl  = new  CategoryImpl();
			
			String sql = "select * from T_category where id=?";
			
			Category category = (Category)categoryimpl.getObject(connection, sql, id); 
			
			request.setAttribute("Category", category);
			
			request.getRequestDispatcher("/Edu/edit.jsp").forward(request, response);
			
		} else if(para.equals("categoryDelete"))
		{
			CategoryImpl categoryimpl  = new  CategoryImpl();
			
			String sql1="delete from t_category where id=?";
			
			categoryimpl.updateDataRecord(connection, sql1, id);
			
			String sql2="select * from t_category order by id";
			 
			List<Category> list  = categoryimpl.getListObject(connection, sql2);
			
			request.setAttribute("Category", list);
			
			request.getRequestDispatcher("/Edu/categories.jsp").forward(request, response);
			
		}else if(para.equals("recordEdit"))
			
		{
			RecordImpl recordimpl = new RecordImpl();
			
			String sql = "select * from T_Record where Rid=?";
			
			Record record = (Record)recordimpl.getObject(connection, sql, id);
			
			request.setAttribute("Record", record);
			
			request.getRequestDispatcher("/Edu/editRecord.jsp").forward(request, response);
			
		}
		else if(para.equals("recordDelete"))
		{
			RecordImpl recordimpl = new RecordImpl();
			
			String sql1 = "delete from t_record where rid=?";
			
			recordimpl.updateDataRecord(connection, sql1, id);
			
			String sql2 ="select * from T_Record order by rid";
			
			List<Record> list = recordimpl.getListObject(connection, sql2);
			
			request.setAttribute("Record", list);
			
			request.getRequestDispatcher("/Edu/record.jsp").forward(request, response);
		}else if(para.equals("scoreEdit"))
		{
			ScoreImpl scoreimpl = new ScoreImpl();
			
			String sql = "select * from t_score where sid=?";
			
			Score score =(Score)scoreimpl.getObject(connection, sql, id);
			
			request.setAttribute("Score", score);
			
			request.getRequestDispatcher("/Edu/editScore.jsp").forward(request, response);
			
			
		}else if(para.equals("scoreDelete"))
		{
			ScoreImpl scoreimpl = new ScoreImpl();
			
			String sql1 = "delete from t_score where sid=?";
			
			scoreimpl.updateDataRecord(connection, sql1,id);
			
			String sql2 = "select * from t_score order by sid";
			
			List<Score> list = scoreimpl.getListObject(connection, sql2);
			
			request.setAttribute("Score", list);
			
			request.getRequestDispatcher("/Edu/score.jsp").forward(request, response);
			
		}
		
		DbUtils.closeConnection(connection);
		
	}

}
