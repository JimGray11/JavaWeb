package com.ywendeng.ecs.action;

import org.apache.struts2.ServletActionContext;

import com.ywendeng.ecs.domain.Cart;
import com.ywendeng.ecs.domain.CartItem;
import com.ywendeng.ecs.domain.Goods;
import com.ywendeng.ecs.service.GoodsService;

@SuppressWarnings("serial")
public class CartAction extends BaseAction{
	
    private CartItem cartItem;
    private  Goods  goods;
    private  GoodsService goodsService;
    
    public String addCart(){
    	//根据商品gid获取当前商品
    	goods=goodsService.findByGid(goods.getGid());
    	cartItem.setGoods(goods);
    	//获取购物车
    	Cart cart=getCart();
    	//将cartItem加入购物车中
    	cart.addCartItem(cartItem);
    	return  null;
    }
    //删除选购商品
    public String delCartItem(){
    	Cart cart=getCart();
    	cart.deleteCartItem(goods.getGid());
    	return "del";
    }
    
    public Cart getCart(){
    	//从session中取出当前购物车
    	Cart cart=(Cart) ServletActionContext.getRequest().
    			     getSession().getAttribute("cart");
    	if(cart==null){
    		cart=new Cart();
    		ServletActionContext.getRequest().getSession()
			                    .setAttribute("cart", cart);
    	}
    	return  cart;
    }
  
    
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
    
    
    
    
    
    
}
