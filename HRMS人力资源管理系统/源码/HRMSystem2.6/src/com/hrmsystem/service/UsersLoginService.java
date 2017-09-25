package com.hrmsystem.service;

import java.sql.Connection;

import com.hrmsystem.dao.impl.UsersLoginImpl;

import com.hrmsystem.domain.UsersLogin;
import com.hrmsystem.utils.DbUtils;

/*
 * 该层主要是业务逻辑层,主要实现和数据库的交互
 */

public class UsersLoginService {
    UsersLoginImpl  usersImpl;
    Connection connection;
    
    public  UsersLoginService(){
    	usersImpl=new UsersLoginImpl();
    	connection=DbUtils.getConnection();
    }
    
    //从数据库中查询用户登录信息是否合法
    public Boolean checkUser(UsersLogin  user){
   String sql="select user_name,password from Users where user_name=?";
   //根据用户名对数据库中的存储信息进行查找
   UsersLogin  dbuser=usersImpl.getObject(connection,sql,user.getUser_name());
 
   //判断该对象是否找到
 	if(dbuser!=null){
 	//判断该用户的密码是否正确
 		
 		 if(dbuser.getPassword().equals(user.getPassword())){
 			  		return true;  
 			
 		 }else{
 			 user.setPassword("");
	    return  false;
 		  }
 	}else{
 		 user.setUser_name("");
 		return false;
  }
}
 
   
}
