package com.ywendeng.ecs.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.User;

import com.opensymphony.xwork2.ActionContext;
import com.ywendeng.ecs.domain.AdminUsers;
import com.ywendeng.ecs.domain.Users;
import com.ywendeng.ecs.service.AdminUsersService;
import com.ywendeng.ecs.service.UsersService;

@SuppressWarnings("serial")
public class AdminUsersAction  extends BaseAction {
	
    AdminUsersService adminUsersService;
    AdminUsers  adminUsers;
    UsersService usersService;
    List<Users> uList;
    private Users user;
    public String  login(){
    	adminUsers=adminUsersService.login(adminUsers);
    	if(adminUsers!=null){
    		//将该用用户存到session中
    		ServletActionContext.getContext().getSession().put("adminUsers", adminUsers);
    		return "login";
    	}
    	return "error";
    }
     public  String  findAll(){
          uList=usersService.findAllUser();
          ActionContext.getContext().getValueStack().set("uList",uList);
       return  "findUsers";
     }
      //删除用户信息 
      public String  delete(){
    	  
    	  
    	  
    	  usersService.deleteUserById(user);
    	  uList=usersService.findAllUser();
          ActionContext.getContext().getValueStack().set("uList",uList);
        return  "findUsers";
      }
     
     
     
	public void setAdminUsersService(AdminUsersService adminUsersService) {
		this.adminUsersService = adminUsersService;
	}


	public AdminUsers getAdminUsers() {
		return adminUsers;
	}


	public void setAdminUsers(AdminUsers adminUsers) {
		this.adminUsers = adminUsers;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public List<Users> getuList() {
		return uList;
	}
	public void setuList(List<Users> uList) {
		this.uList = uList;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
    
    
}
