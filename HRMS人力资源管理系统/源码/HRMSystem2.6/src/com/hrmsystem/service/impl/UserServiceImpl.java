package com.hrmsystem.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hrmsystem.dao.impl.UsersImpl;
import com.hrmsystem.domain.Users;
import com.hrmsystem.service.UserService;
import com.hrmsystem.utils.DbUtils;

public class UserServiceImpl implements UserService{
	UsersImpl  usersImpl;
	Connection  connection;
	public UserServiceImpl(){
		usersImpl=new UsersImpl();
		connection=DbUtils.getConnection();
	}
	

	@Override
	public Users getUserByLoginName(String loginName) {
		String  indexSql="select user_name,depName as departmentName,position_name as positionName,subName as name,image " +
				"from users,positions p,departments d where positionId=p.id" +
				" and departmentId=d.id and user_name=?";
		Users user=usersImpl.getObject(connection, indexSql, loginName);
		//返回根据用户名查询到的用户信息
		return user;
	}
    //对用户密码进行修改
	@Override
	public Boolean updateUserPassword(String loginName,String newPassword) {
	   String upadateSql="update users set password=? where user_name=?";
	   Boolean boolean1= usersImpl.updateDataRecord(connection, upadateSql, newPassword,loginName);
	   return boolean1;
	}


	@Override
	public List<Users> getAllUsers() {
		 String indexAllSql="select user_name,depName as departmentName,position_name as positionName,subName as name,image " +
					"from users,positions p,departments d where positionId=p.id" +
					" and departmentId=d.id";
		  List<Users> list=usersImpl.getListObject(connection, indexAllSql);
		return list;
	}
  
  //根据数据库中总的用户数量计算出总的分页数
	@Override
	public int getPageUserCount() {
		//声明变量  总的分页数
		int  pageSize=3;
		int  pageCount=0;
		 String  total="select count(*) " +
					"from users,positions p,departments d where positionId=p.id" +
					" and departmentId=d.id";
		BigDecimal rowCountBig= usersImpl.getRowCount(connection, total);
		/*
		 * 将 BigDecimal的类型转换为int 型
		 */
		String  rowCountStr=rowCountBig.toString();
		int rowCount=Integer.parseInt(rowCountStr);
		
		//对当前分页情况进行判断
		if(rowCount%pageSize==0){
			pageSize=rowCount/pageSize;
		}else{
			pageCount=rowCount/pageSize+1;
		}
		
		return pageCount;
	}

   //根据页面值 查询数据库中的数据 并将其存放如list集合中
	@Override
	public List<Users> showUserByPage(int pageSize, int pageNow) {
		ArrayList<Users> list=new  ArrayList<Users>();
		String  pageSql="select *from (select rownum rn, user_name,depName as departmentName,position_name as positionName,subName as name,image "
				+ "from users,positions p,departments d where positionId=p.id "+
				"and departmentId=d.id)where rn>?and rn<=?";
		list=(ArrayList<Users>) usersImpl.getListObject(connection, pageSql,pageSize*(pageNow-1),pageSize*pageNow);
		
		return list;
	}
  //删除数据库中的用户记录
	@Override
	public Boolean deleteUserRecord(String delUser) {
		String  delSql="delete users where user_name=?";
		Boolean boolean1=usersImpl.updateDataRecord(connection, delSql,delUser);
		return boolean1;
	}



}
