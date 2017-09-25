package com.hrmsystem.service;

import java.util.List;

import com.hrmsystem.domain.UserInfo;
import com.hrmsystem.domain.UsersLogin;

public interface  UserInfoService {
  /*
   * 保存新建的用户
   */
	Boolean saveUserInfo(UserInfo userInfo);
	/*
	 * 获取数据库中用户名
	 */
	List<UsersLogin> getLoginName();
	
}
