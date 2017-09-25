package com.ywendeng.ecs.domain;
//一条购物信息
public class CartItem {
    
	private  Goods  goods;
	private int count;			// 购买某种商品数量
	private float subtotal;	// 购买某种商品小计
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// 小计自动计算的.
	public float getSubtotal() {
		return count *goods.getPrice();
	}
	
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	
	
}
