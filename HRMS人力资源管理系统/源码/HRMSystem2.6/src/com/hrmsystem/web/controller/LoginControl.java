package com.hrmsystem.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrmsystem.domain.UsersLogin;
import com.hrmsystem.service.UsersLoginService;
import com.hrmsystem.utils.MD5Utils;





@SuppressWarnings("serial")

public class LoginControl extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		
		//将获取的信息封装成一个用户对象
		UsersLoginService  userService=new UsersLoginService();
		//将传输过来的对象封装为对象
		UsersLogin  user=new UsersLogin();
		user.setUser_name(loginName);
		//对用户密码进行加密
		user.setPassword(MD5Utils.MD5Encode(password));
		
		//为用户登录创建会话
		HttpSession  session=request.getSession();
       
	    /*
	     * 设置用户上次登录的时间
	     */
	   setUserLastTime(request, response,session);
		
		Boolean  b=userService.checkUser(user);
		
		
		//用户登录信息正确
		if(b){
		//将用户姓名封装到cookie中去
			session.setAttribute("loginName", user.getUser_name());
			request.getRequestDispatcher("/index.html").forward(request, response);
		}else{
			//用户登录信息不正确，提示相关的错误信息
			if(user.getUser_name().equals("")){
				request.setAttribute("errorMgs", "用户名不存在,请重新输入..");
				
			 }else if(user.getPassword().equals("")){
				 request.setAttribute("errorMgs", "用户密码错误,请重新输入..");
				
			}
			 request.getRequestDispatcher("/loginUI.jsp").forward(request, response);
			}
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	//将每次用户登录的时间保存到cookies 中
	  public void setUserLastTime(HttpServletRequest request,HttpServletResponse response,HttpSession  session){
		  //设置时间格式 
		  SimpleDateFormat  dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String time=dateFormat.format(new java.util.Date());
		  Cookie[] cookies=request.getCookies();
		  //设置一个符号标识位 判断当前用户是否首次登录
		  Boolean b1=false;
		  if(cookies!=null){
			 //对当前当前cookies进行遍历
			  for(Cookie cookie:cookies){
				  if(cookie.getName().equals("lastTime")){
					  session.setAttribute("loginTime", "您上次登录的时间是："+cookie.getValue());
					  cookie.setValue(time);
					  cookie.setMaxAge(24*3600);
					  //把相应的cookie 回写到客户端中
					  response.addCookie(cookie);
					  b1=true;
				  }
			  }
		  }
		  //用户首次登录
		 if(b1==false){
			//在用户首次登录时 ,创建一个cookie 
			 Cookie cookie=new Cookie("lastTime", time);
			 cookie.setMaxAge(24*3600);
			 //把相应的cookie中的消息 写回客户端
			 response.addCookie(cookie);
			 session.setAttribute("loginTime", "欢迎您首次登录！");
			 
		 }
	  }
  
}
