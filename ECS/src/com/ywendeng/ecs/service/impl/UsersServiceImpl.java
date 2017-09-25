package com.ywendeng.ecs.service.impl;

import java.util.List;

import com.ywendeng.ecs.dao.UsersDao;
import com.ywendeng.ecs.domain.Users;
import com.ywendeng.ecs.service.UsersService;

public class UsersServiceImpl implements  UsersService{
    UsersDao  usersDao;
	@Override
	public Users getUserName(String userName) {
		
		return usersDao.getUserName(userName);
	}
	
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public void save(Users user) {
		usersDao.save(user);
	}
 
	@Override
	public Users login(Users user) {
	
		return usersDao.login(user);
	}

	@Override
	public Users getUserByStateCode(String stateCode) {
		
		return usersDao.getUserByStateCode(stateCode);
	}

	public List<Users> findAllUser() {
		
		return usersDao.findAllUser();
	}

	@Override
	public void deleteUserById(Users user) {
		usersDao.deleteUserById(user);
		
	}
   
}
