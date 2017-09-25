package com.ywendeng.ecs.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ywendeng.ecs.domain.Users;
import com.ywendeng.ecs.service.UsersService;
import com.ywendeng.ecs.utils.MailUtils;
import com.ywendeng.ecs.utils.UuidUtils;

@SuppressWarnings("serial")
public class UsersAction extends  BaseAction  {
    Users  user;
    UsersService   usersService;
    String date;
     public String  register() throws Exception{
    	 megMap=new HashMap<>();
    	  try {
    		  user.setStateCode(UuidUtils.getUuid());
    		  usersService.save(user);
    		  //发送用户激活邮件
    		  MailUtils.sendMail(user.getEmail(), user.getStateCode());
  
    		  megMap.put("success",true);
		} catch (Exception e) {
			 megMap.put("success",false);
		}
    	 return  jsonString(megMap);
     }
     //用户激活注册号
     public  String active(){
    	  //根据状态码获取该用户 
    	 user=usersService.getUserByStateCode(user.getStateCode());
    	 if(user!=null){
    		 user.setState(1);
    		 user.setStateCode(null);
    		 usersService.save(user);
    		 this.addActionMessage("该账号已经激活，开启购物之旅吧！");
    	 }else{
    		 this.addActionMessage("账号激活失败，请重新注册...");
    	 }
		return "active";
    	 
     }
     
    /*
     * 查询当前用户名是否已经被注册过
     */
     public String check() throws Exception{
    	 megMap=new HashMap<>();
    	 user=usersService.getUserName(user.getUserName());
    	 if(user!=null){
    		  megMap.put("success",false);
    	 }else{
    		 megMap.put("success",true);
    	 }
		return jsonString(megMap);
    	 
     }
     /*
      * 用户登录
      */
    public String login() throws Exception{
	   Map<String, Boolean>map=new HashMap<>();
	   user=usersService.login(user);
  	 if(user!=null){
  		 //如果用户登录成功，则将该用户信息放入session中
  		  Map<String, Object> session=ActionContext.getContext().getSession();
  		  session.put("user", user);
  		  map.put("meg",true);
  		  
  	 }else{
  		 map.put("meg",false);
  	 }
		return jsonString(map);
    }
     
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
    
    
	
}
