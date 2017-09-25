package com.hrmsystem.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hrmsystem.domain.Users;
import com.hrmsystem.domain.UsersLogin;
import com.hrmsystem.service.impl.UserInfoServiceImpl;
import com.hrmsystem.service.impl.UserServiceImpl;
import com.hrmsystem.utils.MD5Utils;

public class TestUserServiceImpl {

	@Test
	public void testGetUserByLoginName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserPassword() {
		UserServiceImpl  userServiceImpl=new UserServiceImpl();
		Boolean b=userServiceImpl.updateUserPassword("ywendeng", MD5Utils.MD5Encode("111"));
		System.out.print(b);
	}

	@Test
	public void testGetAllUsers() {
	
		UserServiceImpl  userServiceImpl=new UserServiceImpl();
		List<Users> list=userServiceImpl.getAllUsers();
		for(int i=0;i<list.size();i++){
			Users user=list.get(i);
             System.out.println(user.getDepartmentName()+user.getName()+user.getPositionName());
			}
	}
	@Test
    public  void testShowUserByPage(){
    	UserServiceImpl  userServiceImpl=new UserServiceImpl();
		List<Users> list=userServiceImpl.showUserByPage(1, 1);
		for(int i=0;i<list.size();i++){
			Users user=list.get(i);
             System.out.println(user.getDepartmentName()+user.getName()+user.getPositionName());
			}
	}
	
	@Test
	public void testGetPageUserCount(){
		UserServiceImpl  userServiceImpl=new UserServiceImpl();
		userServiceImpl.getPageUserCount();
		
	}
	
	@Test 
	public void testGetAllLoginName(){
		UserInfoServiceImpl  userServiceImpl=new UserInfoServiceImpl();
		List<UsersLogin> list=userServiceImpl.getLoginName();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getUser_name());
		}
	}
    }

