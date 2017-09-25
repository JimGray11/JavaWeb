package com.hrmsystem.domain;

import java.io.Serializable;

public class Positions implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String taskDesc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
