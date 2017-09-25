package com.ywendeng.ecs.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminUsers  implements  Serializable{
  
	private  String  aid;
	private String   userName;
	private String   subName;
	private  Integer role;
	private String  password;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
		
	
}
