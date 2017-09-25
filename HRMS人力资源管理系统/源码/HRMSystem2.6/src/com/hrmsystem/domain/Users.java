package com.hrmsystem.domain;

import java.io.Serializable;
import java.sql.Blob;

/*
 * ::注意：在javaBean 中不能有构造方法，否则，在数据库中提取的数据不能映射成对象，出现cannot create query select*from 
 * 错误::
 */

public class Users extends UsersLogin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/*
	 * 用户的登录信息属性
	 */
	 private String  name;
	 private String  departmentName ;
	 private String  positionName ;
	 private Blob image;
	 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	  
	 
}
