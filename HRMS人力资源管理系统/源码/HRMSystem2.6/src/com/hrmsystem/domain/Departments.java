package com.hrmsystem.domain;

public class Departments {
	//部门编号
	private  int  id;
	//部门名称
    String depName;
   //上级部门的编号
   private int  parentId;
   //职位描述
   String taskDesc;

   
   
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
    
}
