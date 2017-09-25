package com.ywendeng.ecs.domain;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class TwoGoodsType  implements Serializable{
   private String tid;
   private String  name;
   
   private Set<Goods> goods;
   private OneGoodsType oneGoodsType;
   
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Goods> getGoods() {
		return goods;
	}
	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	public OneGoodsType getOneGoodsType() {
		return oneGoodsType;
	}
	public void setOneGoodsType(OneGoodsType oneGoodsType) {
		this.oneGoodsType = oneGoodsType;
	}
   
	
}
