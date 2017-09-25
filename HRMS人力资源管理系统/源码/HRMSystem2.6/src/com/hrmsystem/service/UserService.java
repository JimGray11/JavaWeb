package com.hrmsystem.service;

import java.util.List;

import com.hrmsystem.domain.Users;

public interface UserService {
  /*
   * 根据用户的登录名 ,获取用户的个人信息
   */
	Users getUserByLoginName(String loginName);
	
	/*
	 * 更改用户密码，并返回用户提示信息
	 */
	Boolean updateUserPassword(String loginName,String newPassWord);
	
	/*
	 * 获取数据库中的所以用户信息
	 */
	List<Users>  getAllUsers();
	
	/*
	 * 返回分页的总数
	 */
	int  getPageUserCount();
	
	/*
	 * 显示分页
	 */
	List<Users> showUserByPage(int pageSize,int pageNow);
	/*
	 * 删除数据库中的记录
	 */
	 Boolean deleteUserRecord(String delUser);
}
