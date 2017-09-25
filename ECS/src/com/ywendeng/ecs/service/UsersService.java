package com.ywendeng.ecs.service;

import java.util.List;

import com.ywendeng.ecs.domain.Users;

public interface UsersService {
   
	/*
	 * 查询用户名
	 */
	public  Users getUserName(String userName);

	/*
	 * 保存用户注册信息
	 */
	public void save(Users user);

	public Users login(Users user);
	/*
	 * 根据状态码获取用户
	 */
	public Users getUserByStateCode(String stateCode);

	public List<Users> findAllUser();

	public void deleteUserById(Users user);

	
	
}
