package com.ywendeng.ecs.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class Cart {
	//使用map来存储商品选购商品
    private  Map<String,CartItem> map=new LinkedHashMap<>();
    //计算所有商品的总价钱
    private float total;
    //为了在jsp 页面遍历cart方便 需要将map 转换为单集合
    public Collection<CartItem> getCartItems(){
		return map.values();	
    }
    
    /*
     * 在购物车中封装购物车操作的相关方法
     */
    //① 清空购物车
    public void clearCart(){
    	map.clear();
    	total=0;
    }
    //② 删除购物车中的商品
    public void deleteCartItem(String gid){
    	//在删除商品购物项的时候 ,商品total也需要作出相应的修改
     CartItem  item=map.remove(gid);
     total-=item.getSubtotal();	
    }
    //③ 计算所有商品总的价钱
    public float getTotal(){

		return total;
    	
    }
    //④ 向购物车中添加购物项
    public void addCartItem(CartItem cartItem){
    	//将商品存放到map集合中
    	String gid=cartItem.getGoods().getGid();
    	//判断购物车中该商品是否已经存在
    	if(map.containsKey(gid)){
    	  //将map中的商品取出
    		CartItem  oldCartItem=map.get(gid);
    		oldCartItem.setCount(oldCartItem.getCount()+cartItem.getCount());
    	}else{
    		map.put(gid, cartItem);
    	}
       //设置商品的总价钱
    	total+=cartItem.getSubtotal();
    }
    
}
