package com.hrmsystem.domain;

import java.io.Serializable;

/*
 * 用于显示部门信息
 */
public class DeparmentsShow  extends Departments  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	   //上级部门的部门
	private String  parentName;
	  
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	   
	   
}
