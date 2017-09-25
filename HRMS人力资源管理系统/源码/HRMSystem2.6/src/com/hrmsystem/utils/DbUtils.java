/**
* Title: DbUtils.java
* Description: 
* Copyright: Copyright (c) 2015
* Company: HRMSystem
* @author JimGray
* @date 2015-9-22
* @version 1.0
*/
package com.hrmsystem.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

 /*
 * 实现功能： 
 *  ① 使用c3p0实现数据库的连接
 *  ② 数据库连接资源的关闭 
 */

public class DbUtils {
	/*
	 * 使用c3p0 数据库连接池，实现数据库的连接，由于一个数据库只需要一个数据源实例，故将其设置静态变量
	 */
	private  static DataSource  dataSource=null;
	
	static{
		dataSource=new ComboPooledDataSource("c3p0");
	}
 
	//① 使用c3p0实现数据库的连接
	public static Connection  getConnection(){
		Connection  connection=null;
		
		try {
			 connection=dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("数据库连接异常");
		}
		return connection;
	}
	//② 关闭数据的连接
	public static  void  closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("关闭数据库出现异常");
			}
		}
	}
	//③ 在处理事务时需要取消数据库连接操作的自动提交功能
	public static  void setAutoCommit(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//④ 在数据库操作错误时，需要回滚
	public static void setRoollBack(Connection conn){
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
