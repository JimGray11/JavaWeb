package com.ywendeng.ecs.service.impl;

import com.ywendeng.ecs.dao.AdminUsersDao;
import com.ywendeng.ecs.domain.AdminUsers;
import com.ywendeng.ecs.service.AdminUsersService;

public class AdminUsersServiceImpl implements AdminUsersService {
	AdminUsersDao  adminUsersDao;

	@Override
	public AdminUsers login(AdminUsers adminUsers) {
		
		return adminUsersDao.login(adminUsers);
	}

	public void setAdminUsersDao(AdminUsersDao adminUsersDao) {
		this.adminUsersDao = adminUsersDao;
	}
   
}
