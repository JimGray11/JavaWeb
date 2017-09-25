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
import com.hrmsystem.domain.Category;
import com.hrmsystem.domain.Record;
import com.hrmsystem.domain.Score;


/**
 * Servlet implementation class AddCateServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		
		CategoryImpl categoryimpl = new CategoryImpl();
		
		RecordImpl recordimpl = new RecordImpl();
		
		String para = request.getParameter("actionCode");
		
		Connection connection = DbUtils.getConnection();
		
		 if(para.equals("addcategory"))
		 {
			 
			String id = request.getParameter("id");
			String name= request.getParameter("name");
			String description = request.getParameter("description");
			String remark = request.getParameter("remark");
			
			String sql1 = "insert into  t_category values('"+id+"','"+name+"','"+description+"','"+remark+"') ";
			
			categoryimpl.updateDataRecord(connection, sql1);
			
			//  刷新页面 --------------------------------------
			String sql = "select * from T_category order by id";
			
			List<Category> list = categoryimpl.getListObject(connection, sql);
			
			request.setAttribute("Category", list);
			
			request.getRequestDispatcher("/Edu/categories.jsp").forward(request, response);	
			
		}else if(para.equals("addrecord"))
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
			
			String sql1 = "insert into t_record values('"+id+"','"+rjname+"','"+rcategory+"','"+rbtime+"','"+rotime+"','"+rcost+"','"+raddress+"','"+rhoster+"','"+rmethod+"','"+rpname+"')";
			
			recordimpl.updateDataRecord(connection, sql1);
			
			String sql2 ="select * from T_Record order by rid";
			
			List<Record> list = recordimpl.getListObject(connection, sql2);
			
			request.setAttribute("Record", list);
			
			request.getRequestDispatcher("Edu/record.jsp").forward(request, response);
		}else if(para.equals("addscore"))
		{
			String sid = request.getParameter("sid");
			String spname = request.getParameter("spname");
			String sdname = request.getParameter("sdname");
			String eduname = request.getParameter("eduname");
			String score = request.getParameter("score");
			String pass = request.getParameter("pass");
			
			ScoreImpl scoreimpl = new ScoreImpl();
			
			String sql1 = "insert into t_score values('"+sid+"','"+spname+"','"+sdname+"','"+eduname+"','"+score+"','"+pass+"')";
			
			scoreimpl.updateDataRecord(connection, sql1);
			
			String sql2 = "select * from t_score order by sid";
			
			List<Score> list = scoreimpl.getListObject(connection, sql2);
			
			request.setAttribute("Score", list);
			
			request.getRequestDispatcher("/Edu/score.jsp").forward(request, response);
			
		}
		 
		 
		
		DbUtils.closeConnection(connection);
	}

}
