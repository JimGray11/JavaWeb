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
import com.hrmsystem.domain.Score;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		String sel = request.getParameter("sel");
		
		String searcher = request.getParameter("searcher");
		
		ScoreImpl scoreimpl = new ScoreImpl();
		
		Connection connection = DbUtils.getConnection();
		
		if(sel.equals("1"))
		{
			String sql = "select spname,sdname,eduname,score,pass from t_score where spname=?";
			
			List<Score> list = scoreimpl.getListObject(connection, sql, searcher);
			
			if(list!=null){
			
			request.setAttribute("List", list);
			
			request.getRequestDispatcher("/Edu/Search.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/Edu/failure.html").forward(request, response);
			}
			
		}else if(sel.equals("2"))
		{
			String sql = "select spname,sdname,eduname,score,pass from t_score where eduname=? ";
			
			List<Score> list = scoreimpl.getListObject(connection, sql, searcher);
			
			if(list!=null){
			
			request.setAttribute("List", list);
			
			request.getRequestDispatcher("/Edu/Search.jsp").forward(request, response);
			
			}else {
				request.getRequestDispatcher("/Edu/failure.html").forward(request, response);
			}
			
		}else if(sel.equals("3"))
		{
			String sql = "select spname,sdname,eduname,score,pass from t_score where sdname=? ";
			
			List<Score> list = scoreimpl.getListObject(connection, sql, searcher);
			
			if(list!=null){
			
			request.setAttribute("List", list);
			
			request.getRequestDispatcher("/Edu/Search.jsp").forward(request, response);
			
			}else {
				request.getRequestDispatcher("/Edu/failure.html").forward(request, response);
			}
		}
	}

}
