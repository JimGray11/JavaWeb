package com.ywendeng.ecs.domain;

import java.util.Date;
import java.util.Set;

public class Goods {
   private  String gid;
   private  String  name;
   private  float  price;
   private  float  marketPrice;
   private  String description;
   private  String image;
   private Integer is_hot;
   private Date pdate;
   private TwoGoodsType  twoGoodsType;
   private  Set<OrderItem> orderItems;
   
   
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public TwoGoodsType getTwoGoodsType() {
		return twoGoodsType;
	}
	public void setTwoGoodsType(TwoGoodsType twoGoodsType) {
		this.twoGoodsType = twoGoodsType;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	   
   
   
}
