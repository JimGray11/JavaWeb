package com.hrmsystem.domain;

/*
 * 用于统计所有的在线人数
 */

public class Counter {
   private  int count;

	public int getCount() {
		return ++count;//每访问一次 自动加1
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	   
	   
}
