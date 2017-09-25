package com.ywendeng.ecs.domain;

import java.io.Serializable;
/*
 * 订单项表
 */
@SuppressWarnings("serial")
public class OrderItem implements Serializable {
    private String itemId;
	private Integer count;
	private float subtotal;
	// 商品外键:对象
	private Goods  goods;
	// 订单外键:对象
	private Orders order;
	

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
}
