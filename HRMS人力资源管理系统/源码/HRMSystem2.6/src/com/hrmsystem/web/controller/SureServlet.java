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
 * Servlet implementation class CateServletSure
 */
public class SureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
    public SureServlet() {
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
		
		String  actionCode =request.getParameter("actionCode");
		
		Connection connection = DbUtils.getConnection();
		
		if(actionCode.equals("category"))
		{
			String id = request.getParameter("id");
			String name= request.getParameter("name");
			String description = request.getParameter("description");
			String remark = request.getParameter("remark");
			
			//更改数据库数据
			
			CategoryImpl categoryimpl = new CategoryImpl();
			
			String sql1 = "update t_category set categoryname='"+name+"',description='"+description+"',remark='"+remark+"' where id=?";
			
			categoryimpl.updateDataRecord(connection, sql1, id);
			
			// 刷新页面。
			String sql = "select * from T_category order by id";
			
			List<Category> list = categoryimpl.getListObject(connection, sql);
			
			request.setAttribute("Category", list);
			
			request.getRequestDispatcher("/Edu/categories.jsp").forward(request, response);	
			
		}else if(actionCode.equals("record"))
		{
			String id = request.getParameter("id");
			String rcategory = request.getParameter("rcategory");
			String rbtime = request.getParameter("rbtime");
			String rotime = request.getParameter("rotime");
			String rjname = request.getParameter("rjname");
			String rcost = request.getParameter("rcost");
			String rhoster = request.getParameter("rhoster");
			String rpname = request.getParameter("rpname");
			String rmethod = request.getParameter("rmethod");
			String raddress = request.getParameter("raddress");
			
			RecordImpl recordimpl = new RecordImpl();
			
			String sql = "update t_record set rcategory='"+rcategory+"',rbtime='"+rbtime+"',rotime='"+rotime+"',rjname='"+rjname+"',"
					+ "rcost='"+rcost+"',rhoster='"+rhoster+"',rpname='"+rpname+"',rmethod='"+rmethod+"',raddress='"+raddress+"' where rid=?";
			
			recordimpl.updateDataRecord(connection, sql, id);
			
			String sql2 = "select * from T_record order by rid";
			
			List<Record> list = recordimpl.getListObject(connection, sql2);
			
			request.setAttribute("Record", list);
			
			request.getRequestDispatcher("/Edu/record.jsp").forward(request, response);	
			
		}else if(actionCode.equals("score"))
		{
			String sid = request.getParameter("sid");
			String spname = request.getParameter("spname");
			String sdname = request.getParameter("sdname");
			String eduname = request.getParameter("eduname");
			String score = request.getParameter("score");
			String pass = request.getParameter("pass");
			
			ScoreImpl scoreimpl = new ScoreImpl();
			
			String sql1 = "update t_score set spname='"+spname+"',sdname='"+sdname+"',eduname='"+eduname+"',score='"+score+"',pass='"+pass+"' where sid=?";
		
			scoreimpl.updateDataRecord(connection, sql1, sid);
			
			String sql2 = "select * from t_score order by sid";
			
			List<Score> list = scoreimpl.getListObject(connection, sql2);
			
			request.setAttribute("Score", list);
			
			request.getRequestDispatcher("/Edu/score.jsp").forward(request, response);
		}
		
		DbUtils.closeConnection(connection);
	}

}
