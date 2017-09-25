package com.hrmsystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.hrmsystem.dao.impl.UserInfoImpl;
import com.hrmsystem.dao.impl.UsersLoginImpl;
import com.hrmsystem.domain.UserInfo;
import com.hrmsystem.domain.UsersLogin;
import com.hrmsystem.service.UserInfoService;
import com.hrmsystem.utils.DbUtils;

public class UserInfoServiceImpl implements UserInfoService {
   UserInfoImpl  userInfoImpl;
   Connection connection;
   UsersLoginImpl loginImpl;
	 public UserInfoServiceImpl() {
		 
		userInfoImpl=new UserInfoImpl();
		connection=DbUtils.getConnection();
		loginImpl=new UsersLoginImpl();
	}
	@Override
	public Boolean saveUserInfo(UserInfo userInfo) {
		//向数据库users表中插入数据
		String insertSql="insert into users(id,user_name,gender，password,departmentId,positionId,image,tell_phone,e_mail,remarks) "+
   "values(user_id.nextVal,?,?,'111',?,?,'',?,?,?)";
	Boolean b=userInfoImpl.updateDataRecord(connection,insertSql,userInfo.getLoginName(),userInfo.getGender(),userInfo.getDepartmentId(),
				userInfo.getPositionId(),userInfo.getTell_phone(),userInfo.getE_mail(),userInfo.getRemarks());
		
		return  b;
	}
	//获取数据库中的所有用户名
	@Override
	public List<UsersLogin> getLoginName() {
		String indexSql="select user_name,password from users";
		List<UsersLogin> list=loginImpl.getListObject(connection, indexSql);
		return list;
	}
	
}
