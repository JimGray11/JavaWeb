package com.ywendeng.ecs.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("serial")
public class Orders implements Serializable{
	private String orid;
	private float total;
	private Date ordertime;
	private Integer orderState;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String name;
	private String phone;
	private String addr;
	// 用户的外键:对象
	private Users user;
	
	// 配置订单项的集合
	private Set<OrderItem> orderItems;



	public String getOrid() {
		return orid;
	}

	public void setOrid(String orid) {
		this.orid = orid;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

  public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
